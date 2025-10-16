package com.example.Notification.Service.service;

import com.example.Notification.Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getAllUsers() {
        return userRepository.findAll().toString();
    }
}
