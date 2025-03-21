package com.example.test_1221_cal.service.user;

import com.example.test_1221_cal.dto.UserDTO;

import java.util.List;

public interface UserService {

    long addUser(UserDTO user);

    void eatFood(Long userId, List<Long> foodId);
}
