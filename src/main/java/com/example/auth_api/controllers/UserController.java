package com.example.auth_api.controllers;
import com.example.auth_api.entities.User;


import com.example.auth_api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/email")
    public ResponseEntity<Object> emailPost(@RequestBody Object obj) {
        try{
            System.out.println(obj.toString());
            return ResponseEntity.ok(obj);
        }catch (Exception e){
            return ResponseEntity.ok(obj);
        }
    }
    @PutMapping("/email")
    public ResponseEntity<Object> emailPut(@RequestBody Object obj) {
        try{
            System.out.println(obj.toString());
            return ResponseEntity.ok(obj);
        }catch (Exception e){
            return ResponseEntity.ok(obj);
        }
    }
}