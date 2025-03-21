package com.example.test_1221_cal.controller;

import com.example.test_1221_cal.dto.DailyReportDTO;
import com.example.test_1221_cal.service.report.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;


    @GetMapping("/daily/{userId}")
    public ResponseEntity<DailyReportDTO> getDailyReport(@PathVariable Long userId, @RequestParam LocalDate date) {
        try {
            return ResponseEntity.ok(reportService.getDailyReport(userId, date));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/check-calories/{userId}")
    public ResponseEntity<Boolean> checkCalories(@PathVariable Long userId, @RequestParam LocalDate date) {
        try {
            return ResponseEntity.ok(reportService.isWithinCalorieLimit(userId, date));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(false);
        }
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<DailyReportDTO>> getFoodHistory(@PathVariable Long userId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        try {
            return ResponseEntity.ok(reportService.getFoodHistory(userId, startDate, endDate));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
