package com.example.Notification.Service.controller;

import com.example.Notification.Service.configuration.JWTCore;
import com.example.Notification.Service.model.InputSignupAndSigninData;
import com.example.Notification.Service.model.User;
import com.example.Notification.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTCore jwtCore;

    @GetMapping("/data")
    @ResponseBody
    public ResponseEntity getData(Principal principal) {
        return ResponseEntity.ok().body(principal.getName());
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity signup(@RequestBody InputSignupAndSigninData data) {
        if (userService.isExists(data.name)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The username is already exists!");
        }
        System.out.println(data.password);
        User user = new User(data);
        userService.save(user);
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.name, data.password);
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok().body(jwtCore.generateToken(authentication));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR ON SERVER");
        }
    }

}
