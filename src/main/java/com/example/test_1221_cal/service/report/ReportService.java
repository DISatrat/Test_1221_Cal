package com.example.test_1221_cal.service.report;

import com.example.test_1221_cal.dto.DailyReportDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    DailyReportDTO getDailyReport(Long userId, LocalDate date);
    boolean isWithinCalorieLimit(Long userId, LocalDate date);
    List<DailyReportDTO> getFoodHistory(Long userId, LocalDate startDate, LocalDate endDate);
}
