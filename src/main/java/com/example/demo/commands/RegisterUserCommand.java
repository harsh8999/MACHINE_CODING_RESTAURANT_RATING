package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

public class RegisterUserCommand implements ICommand {

    private UserService userService;

    public RegisterUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // REGISTER_USER <name>
        // Example : REGISTER_USER ANAND
        String name = tokens.get(1);

        User user = userService.create(name);

        // Output : User [id=1]
        System.out.println(user);
    }
    
}
