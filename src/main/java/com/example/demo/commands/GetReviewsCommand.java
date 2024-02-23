package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.entities.ReviewOrderEnum;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand {

    private ReviewService reviewService;

    public GetReviewsCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // GET_REVIEWS <restaurant_id> <order>
        // Example : GET_REVIEWS 2 RATING_DESC
        Integer restaurantId = Integer.parseInt(tokens.get(1));
        ReviewOrderEnum order = ReviewOrderEnum.valueOf(tokens.get(2));
        List<Review> reviews = reviewService.getReviewsInOrder(restaurantId, order);
        // Output : [Review [id=7], Review [id=5], Review [id=6], Review [id=8]]
        System.out.println(reviews);
        
    }
    
}
