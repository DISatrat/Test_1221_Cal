package com.example.test_1221_cal.controller;

import com.example.test_1221_cal.dto.FoodDTO;
import com.example.test_1221_cal.service.food.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {

    private FoodService foodService;

    @PostMapping()
    public ResponseEntity<?> addFoodList(@RequestBody List<FoodDTO> food) {
        try {
            foodService.addFood(food);
            return ResponseEntity.ok("food added !");
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
