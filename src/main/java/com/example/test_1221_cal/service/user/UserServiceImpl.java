package com.example.test_1221_cal.service.user;

import com.example.test_1221_cal.dao.FoodDAO;
import com.example.test_1221_cal.dao.UserDAO;
import com.example.test_1221_cal.dao.UserFoodDAO;
import com.example.test_1221_cal.dto.UserDTO;
import com.example.test_1221_cal.mapper.UserMapper;
import com.example.test_1221_cal.model.Food;
import com.example.test_1221_cal.model.User;
import com.example.test_1221_cal.model.UserFood;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final FoodDAO foodDAO;
    private final UserFoodDAO userFoodDAO;
    private final UserMapper userMapper;

    @Override
    public long addUser(UserDTO user) {
        User savedUser = userDAO.save(userMapper.toEntity(user));

        savedUser.setCalories(savedUser.caloriesCals());
        userDAO.save(savedUser);
        return savedUser.getId();
    }

    @Override
    public void eatFood(Long userId, List<Long> foodIds) {
        User user = userDAO.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        List<Food> foods = foodDAO.findAllById(foodIds);
        if (foods.size() != foodIds.size()) {
            throw new RuntimeException("Some food items were not found");
        }

        List<UserFood> userFoods = foods.stream().map(food -> {
            UserFood userFood = new UserFood();
            userFood.setUser(user);
            userFood.setFood(food);
            userFood.setWhenAte(LocalDate.now());
            return userFood;
        }).collect(Collectors.toList());

        userFoodDAO.saveAll(userFoods);
    }


}
