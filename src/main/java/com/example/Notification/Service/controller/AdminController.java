package com.example.Notification.Service.controller;

import com.example.Notification.Service.model.User;
import com.example.Notification.Service.service.UserService;
import com.example.Notification.Service.util.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{name}")
    public ResponseEntity getUserData(@PathVariable(value = "name") String name) {
        ConsoleHelper.printInformation("user data request by name " + name, ConsoleHelper.MessageType.INFO);
        User user = userService.getUser(name);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Такого пользователя не существует");
        }
        return ResponseEntity.ok().body(user.toString());
    }

    @PostMapping("/signup")
    public ResponseEntity postUser(@RequestParam(value = "name", defaultValue = "Robert") String username, @RequestParam(value = "password", defaultValue = "r1r1r1r123") String password) {
        ConsoleHelper.printInformation("user data request by name " + username + "password " + password, ConsoleHelper.MessageType.INFO);
        User user = userService.getUser(username);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user with this username is already exists");
        }
        user = new User(username, password);
        userService.save(user);
        return ResponseEntity.ok().body("The account was created");
    }

}
