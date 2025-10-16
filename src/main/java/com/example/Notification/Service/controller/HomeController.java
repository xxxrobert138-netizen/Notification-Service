package com.example.Notification.Service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public ResponseEntity getHomePage(@RequestParam(value = "name", defaultValue = "Robert") String name) {
        System.out.println("home");
        return ResponseEntity.ok().body(String.format("Hello, %s!", name));
    }

}
