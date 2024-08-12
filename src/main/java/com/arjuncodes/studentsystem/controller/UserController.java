package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.User;
import com.arjuncodes.studentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user.getPassword() == null || user.getConfirmPassword() == null) {
            return ResponseEntity.badRequest().body("Password and Confirm Password cannot be null");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        }

        if (user.getUsername().length() < 5) {
            return ResponseEntity.badRequest().body("Username must be at least 5 characters long");
        }

        // Vérifiez si l'utilisateur existe déjà par nom d'utilisateur ou mot de passe
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("User with this username already exists");
        }


        // Vous pouvez également vérifier si le mot de passe existe déjà dans votre logique métier.
        // C'est peu probable, mais faisable si vous avez des exigences spécifiques.

        // Encoder le mot de passe avant d'enregistrer
        userService.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && user.getPassword().equals(foundUser.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
