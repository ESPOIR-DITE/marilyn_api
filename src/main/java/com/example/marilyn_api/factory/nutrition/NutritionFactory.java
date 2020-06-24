package com.example.marilyn_api.factory.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import com.example.marilyn_api.util.GeneratId;

public class NutritionFactory {
    public static Nutrition getNutrition(String nutritionType,String name,String description,double price){
        return new Nutrition.Builder(GeneratId.getId(NutritionFactory.class))
                .buildDescription(description)
                .builderPrice(price)
                .buildName(name)
                .buildNutritionType(nutritionType)
                .build();
    }
}
