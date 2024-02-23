package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.entities.ReviewOrderEnum;
import com.example.demo.entities.User;
import com.example.demo.repositories.IReviewRepository;


public class ReviewService {

    private IReviewRepository reviewRepository;
    private UserService userService;
    private RestaurantService restaurantService;
    
    public ReviewService(IReviewRepository reviewRepository, UserService userService,
            RestaurantService restaurantService) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    public Review create(Integer userId, Integer restaurantId, Double rating , String dishes, String description) {
        User user = userService.getUser(userId);
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        Review review = new Review(null, user, restaurant, rating, dishes, description);
        Review r = reviewRepository.save(review);
        restaurantService.calculateRatings(restaurant, getReviewOfRestaurant(r.getRestaurant().getId()));
        return r;
    }

    

    private List<Review> getReviewOfRestaurant(Integer id) {
        return reviewRepository.findAll().stream().filter(e -> e.getRestaurant().getId() == id).collect(Collectors.toList());
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReview(Integer id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review with id: " + id + " not found!"));
    }

    public List<Review> getReviewsInOrder(Integer restaurantId, ReviewOrderEnum order) {
        List<Review> reviews = reviewRepository.findAll();
        if(order == ReviewOrderEnum.RATING_ASC) {
            return reviews.stream().filter(e -> e.getRestaurant().getId() == restaurantId).sorted((a, b) -> a.getRating().compareTo(b.getRating())).collect(Collectors.toList());
        }
        return reviews.stream().filter(e -> e.getRestaurant().getId() == restaurantId).sorted((a, b) -> b.getRating().compareTo(a.getRating())).collect(Collectors.toList());
    }

    public List<Review> getReviewsFilterByRatingsInOrder(Integer restaurantId, Integer low, Integer high, ReviewOrderEnum order) {
        List<Review> reviews = reviewRepository.findAll();
        if(order == ReviewOrderEnum.RATING_ASC) {
            return reviews.stream().filter(e -> e.getRating() >= low && e.getRating() <= high).filter(e -> e.getRestaurant().getId() == restaurantId).sorted((a, b) -> a.getRating().compareTo(b.getRating())).collect(Collectors.toList());
        }
        return reviews.stream().filter(e -> e.getRating() >= low && e.getRating() <= high).filter(e -> e.getRestaurant().getId() == restaurantId).sorted((a, b) -> b.getRating().compareTo(a.getRating())).collect(Collectors.toList());
    }
    
}
