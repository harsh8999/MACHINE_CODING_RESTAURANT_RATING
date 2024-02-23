package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class RegisterRestaurantCommand implements ICommand {

    private RestaurantService restaurantService;

    public RegisterRestaurantCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // REGISTER_RESTAURANT <name>
        // Example : REGISTER_RESTAURANT “Mama’s Kitchen”
        String name = tokens.get(1);

        Restaurant restaurant = restaurantService.create(name);

        // Output : Restaurant [id=1]
        System.out.println(restaurant);
    }
}
