package com.example.test_1221_cal.controller;

import com.example.test_1221_cal.dto.UserDTO;
import com.example.test_1221_cal.service.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){

        try {
            long id = userService.addUser(userDTO);
            return ResponseEntity.ok(String.format("User added with id: %s", id));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/{userId}/eat")
    public ResponseEntity<String> eat(@PathVariable Long userId, @RequestBody List<Long> foodIds) {
        try {
            userService.eatFood(userId, foodIds);
            return ResponseEntity.ok("Meal added successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
