package com.example.test_1221_cal.service.report;

import com.example.test_1221_cal.dao.UserFoodDAO;
import com.example.test_1221_cal.dto.DailyReportDTO;
import com.example.test_1221_cal.model.UserFood;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final UserFoodDAO userFoodDAO;

    @Override
    public DailyReportDTO getDailyReport(Long userId, LocalDate date) {
        List<UserFood> userFoods = userFoodDAO.findByUser_IdAndWhenAte(userId, date);

        int totalCalories = userFoods.stream()
                .mapToInt(uf -> uf.getFood().getCalories())
                .sum();

        int mealCount = userFoods.size();

        return new DailyReportDTO(date, totalCalories, mealCount);
    }

    @Override
    public boolean isWithinCalorieLimit(Long userId, LocalDate date) {

        List<UserFood> userFoods = userFoodDAO.findByUser_IdAndWhenAte(userId, date);

        int totalCalories = userFoods.stream()
                .mapToInt(uf -> uf.getFood().getCalories())
                .sum();

        return totalCalories <= 2000;
    }

    @Override
    public List<DailyReportDTO> getFoodHistory(Long userId, LocalDate startDate, LocalDate endDate) {
        List<DailyReportDTO> reports = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            List<UserFood> userFoods = userFoodDAO.findByUser_IdAndWhenAte(userId, currentDate);

            int totalCalories = userFoods.stream()
                    .mapToInt(uf -> uf.getFood().getCalories())
                    .sum();

            int mealCount = userFoods.size();

            reports.add(new DailyReportDTO(currentDate, totalCalories, mealCount));

            currentDate = currentDate.plusDays(1);
        }

        return reports;
    }

}