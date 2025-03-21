package com.example.test_1221_cal.service.food;

import com.example.test_1221_cal.dao.FoodDAO;
import com.example.test_1221_cal.dto.FoodDTO;
import com.example.test_1221_cal.mapper.FoodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodDAO foodDAO;
    private final FoodMapper foodMapper;

    @Override
    public void addFood(List<FoodDTO> foodList) {
        foodList
                .forEach(x -> foodDAO.save(foodMapper.toEntity(x)));
    }
}
