package com.example.Notification.Service.repository;

import com.example.Notification.Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

    boolean existsByUserName(String username);
}
