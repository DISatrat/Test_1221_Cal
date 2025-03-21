package com.example.test_1221_cal.dao;

import com.example.test_1221_cal.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDAO extends JpaRepository<Food, Long> {
}
