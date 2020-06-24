package com.example.marilyn_api.factory.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionType;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class NutritionTypeFactory {
    public static NutritionType getNutritionType(String nutritionType,Date date){
        return new NutritionType.Builder(GeneratId.getId(NutritionTypeFactory.class))
                .buildDate(date)
                .buildNutritionType(nutritionType)
                .build();
    }
}
