package com.example.test_1221_cal.service;

import com.example.test_1221_cal.dao.FoodDAO;
import com.example.test_1221_cal.dto.FoodDTO;
import com.example.test_1221_cal.mapper.FoodMapper;
import com.example.test_1221_cal.model.Food;
import com.example.test_1221_cal.service.food.FoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FoodServiceTest {

    @Mock
    private FoodDAO foodDAO;

    @Mock
    private FoodMapper foodMapper;

    private FoodServiceImpl foodService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        foodService = new FoodServiceImpl(foodDAO, foodMapper);
    }

    @Test
    void testAddFood() {
        FoodDTO foodDTO1 = new FoodDTO("Food1", 100, 5, 3, 10);
        FoodDTO foodDTO2 = new FoodDTO("Food2", 200, 10, 6, 20);

        Food food1 = new Food("Food1", 100, 5, 3, 10);
        Food food2 = new Food("Food2", 200, 10, 6, 20);

        List<FoodDTO> foodDTOList = Arrays.asList(foodDTO1, foodDTO2);

        when(foodMapper.toEntity(foodDTO1)).thenReturn(food1);
        when(foodMapper.toEntity(foodDTO2)).thenReturn(food2);

        foodService.addFood(foodDTOList);

        verify(foodDAO).save(food1);
        verify(foodDAO).save(food2);
    }
}
