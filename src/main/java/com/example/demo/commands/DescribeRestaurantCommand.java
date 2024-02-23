package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class DescribeRestaurantCommand implements ICommand {

    private RestaurantService restaurantService;

    public DescribeRestaurantCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // DESCRIBE_RESTAURANT <restaurant_id>
        // Example : DESCRIBE_RESTAURANT 2
        Integer restaurantId = Integer.parseInt(tokens.get(1));
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        // Output: Restaurant [id=1, name=A2B, rating=2.6]
        System.out.println("Restaurant [id="+restaurantId+", name="+restaurant.getName()+", rating="+restaurant.getRating()+"]");
    }
    
}
