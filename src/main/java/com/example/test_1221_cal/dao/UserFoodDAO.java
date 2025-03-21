package com.example.test_1221_cal.dao;

import com.example.test_1221_cal.model.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserFoodDAO extends JpaRepository<UserFood, Long> {

    List<UserFood> findByUser_IdAndWhenAte(Long userId, LocalDate date);
}
