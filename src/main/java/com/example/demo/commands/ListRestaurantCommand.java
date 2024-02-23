package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class ListRestaurantCommand implements ICommand{

    private RestaurantService restaurantService;

    public ListRestaurantCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Restaurant> restaurants = restaurantService.getRestaurantOrderDescOnRating();
        System.out.println(restaurants);
    }   
    
}
