package com.example.test_1221_cal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DailyReportDTO {
    private LocalDate date;
    private int totalCalories;
    private int mealCount;
}
