package com.example.marilyn_api.controller.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionType;
import com.example.marilyn_api.controller.Icontroller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fcma/nutrition_type/")
public class NutritionTypeController implements Icontroller<NutritionType,String> {
    @Override
    public NutritionType create(NutritionType nutritionType) {
        return null;
    }

    @Override
    public NutritionType read(String id) {
        return null;
    }

    @Override
    public NutritionType update(NutritionType nutritionType) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public List<NutritionType> readALl() {
        return null;
    }

    @Override
    public List<NutritionType> readALlOff(String id) {
        return null;
    }
}
