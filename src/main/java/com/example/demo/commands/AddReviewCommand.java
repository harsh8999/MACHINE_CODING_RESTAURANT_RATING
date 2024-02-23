package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class AddReviewCommand implements ICommand {

    private ReviewService reviewService;

    public AddReviewCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // ADD_REVIEW <rating>  <userId> <restaurantId> <list of dish_names> <description>
        // Example : ADD_REVIEW 4 1 2 “pav bhaji dosa” “pav bhaji and dosa was tasty”
        Double rating = Double.parseDouble(tokens.get(1));
        Integer userId = Integer.parseInt(tokens.get(2));
        Integer restaurantId = Integer.parseInt(tokens.get(3));
        String dishes = tokens.get(4);
        String description = tokens.get(5);

        Review review = reviewService.create(userId, restaurantId, rating, dishes, description);

        // Output : Review [id=4] added successfully for Restaurant [id=1] by User [id=4]!
        System.out.println(review + " added successfully for " + review.getRestaurant() + " by " + review.getUser() + "!");
        
    }

    
}
