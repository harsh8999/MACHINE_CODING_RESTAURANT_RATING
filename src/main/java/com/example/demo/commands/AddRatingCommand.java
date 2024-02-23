package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class AddRatingCommand implements ICommand {

    private ReviewService reviewService;

    public AddRatingCommand(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // ADD_RATING <rating> <userId> <restaurantId>
        // Example : ADD_RATING 3 1 2
        Double rating = Double.parseDouble(tokens.get(1));
        Integer userId = Integer.parseInt(tokens.get(2));
        Integer restaurantId = Integer.parseInt(tokens.get(3));

        Review review = reviewService.create(userId, restaurantId, rating, null, null);

        // Output : Review [id=4] added successfully for Restaurant [id=1] by User [id=4]!
        System.out.println(review + " added successfully for " + review.getRestaurant() + " by " + review.getUser() + "!");
        
    }

}
