package com.example.test_1221_cal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class FoodDTO {

    private String name;

    private int calories;

    private int proteins;

    private int fats;

    private int carbohydrates;

}
