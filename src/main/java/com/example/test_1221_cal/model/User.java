package com.example.test_1221_cal.model;

import com.example.test_1221_cal.model.enums.Aim;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Getter
@Service
@NoArgsConstructor
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 255, message = "Username must be between 3 and 255 characters")
    private String username;

    @Email
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than 100")
    private int age;

    @Min(value = 30, message = "Weight must be at least 30kg")
    @Max(value = 300, message = "Weight must be less than 300kg")
    private int weight;


    @Min(value = 50, message = "Height must be at least 50cm")
    @Max(value = 250, message = "Height must be less than 250cm")
    private int height;

    // true - женщина
    // false - мужчина
    private boolean sex;

    @Enumerated(EnumType.STRING)
    private Aim aim;

    @OneToMany(mappedBy = "user")
    private List<UserFood> userFoods;

    private double calories;

    public int caloriesCals() {
        double cal;
        System.out.println(this.age);
        System.out.println(this.weight);
        System.out.println(this.height);
        if (!this.sex) {
            // Мужчины
            cal = 88.362 + (13.397 * this.weight) + (4.799 * this.height) - (5.677 * this.age);
            System.out.println(cal);
        } else {
            // Женщины
            cal = 447.593 + (9.247 * this.weight) + (3.098 * this.height) - (4.330 * this.age);
        }

        if (this.aim == Aim.WEIGHT_GAINING) {
            return (int)( cal * 1.15);
        } else if (this.aim == Aim.WEIGHT_LOSS) {
            return (int)(cal * 0.85);
        }

        return  (int)(cal * 1.2);
    }

}
