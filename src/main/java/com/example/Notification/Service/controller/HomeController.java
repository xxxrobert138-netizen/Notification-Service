package com.example.Notification.Service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public ResponseEntity getHomePage(@RequestParam(value = "name", defaultValue = "Robert") String name) {
        System.out.println("home");
        return ResponseEntity.ok().body(String.format("Hello, %s!", name));
    }

    @GetMapping("/{n}")
    public ResponseEntity getHomePageWithPathVariable(@PathVariable(value = "n") String name) {
        return ResponseEntity.ok().body(String.format("Hi, %s", name));
    }

}
