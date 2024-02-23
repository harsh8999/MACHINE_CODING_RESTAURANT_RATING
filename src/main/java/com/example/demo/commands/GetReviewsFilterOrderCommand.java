package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.entities.ReviewOrderEnum;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrderCommand implements ICommand {

    private ReviewService reviewService;

    public GetReviewsFilterOrderCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // GET_REVIEWS_FILTER_ORDER  <restaurant_id> <low> <high> <order>
        // Example : GET_REVIEWS_FILTER_ORDER 2 2 5 RATING_DESC
        Integer restaurantId = Integer.parseInt(tokens.get(1));
        Integer low = Integer.parseInt(tokens.get(2));
        Integer high = Integer.parseInt(tokens.get(3));
        ReviewOrderEnum order = ReviewOrderEnum.valueOf(tokens.get(4));
        List<Review> reviews = reviewService.getReviewsFilterByRatingsInOrder(restaurantId, low, high, order);
        // Output : [Review [id=7], Review [id=5], Review [id=6], Review [id=8]]
        System.out.println(reviews);
        
    }
    
}
