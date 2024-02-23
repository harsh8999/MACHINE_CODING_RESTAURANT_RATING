package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.repositories.IRestaurantRepository;

public class RestaurantService {

    private IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant create(String name) {
        Restaurant user = new Restaurant(null, name);
        return restaurantRepository.save(user);
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with id: " + id + " not found!"));
    }

    public Restaurant updateRatings(Integer restaurantId, Double rating) {
        return restaurantRepository.updateRating(restaurantId, rating);
    }

    public List<Restaurant> getRestaurantOrderDescOnRating() {
        return restaurantRepository.findAll().stream().sorted((a, b) -> b.getRating().compareTo(a.getRating())).collect(Collectors.toList());
    }

    public void calculateRatings(Restaurant restaurant, List<Review> reviews) {
        Long countOfRating1 = reviews.stream().filter(e -> e.getRating() == 1).count();
        Long countOfRating2 = reviews.stream().filter(e -> e.getRating() == 2).count();
        Long countOfRating3 = reviews.stream().filter(e -> e.getRating() == 3).count();
        Long countOfRating4 = reviews.stream().filter(e -> e.getRating() == 4).count();
        Long countOfRating5 = reviews.stream().filter(e -> e.getRating() == 5).count();
        double n = ((1 * countOfRating1) + (2 * countOfRating2) + (3 * countOfRating3) + (4 * countOfRating4) + (5 * countOfRating5));
        double d = (countOfRating1 + countOfRating2 + countOfRating3 + countOfRating4 + countOfRating5);
        double rating = n / d;
        updateRatings(restaurant.getId(), rating);
    }
}
