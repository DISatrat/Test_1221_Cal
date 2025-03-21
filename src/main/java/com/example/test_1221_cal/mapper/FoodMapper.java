package com.example.test_1221_cal.mapper;

import com.example.test_1221_cal.dto.FoodDTO;
import com.example.test_1221_cal.model.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food toEntity(FoodDTO dto);

}
