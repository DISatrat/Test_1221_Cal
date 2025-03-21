package com.example.test_1221_cal.dto;

import com.example.test_1221_cal.model.enums.Aim;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserDTO {
    private String username;

    private String email;

    private int age;

    private int weight;

    private int height;

    // true - женщина
    // false - мужчина
    private boolean sex;

    @Enumerated(EnumType.STRING)
    private Aim aim;
}
