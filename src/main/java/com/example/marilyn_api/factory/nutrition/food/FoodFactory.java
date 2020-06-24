package com.example.marilyn_api.factory.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Food;
import com.example.marilyn_api.util.GeneratId;

public class FoodFactory {
    public static Food getFood(String foodName,String description){
        return new Food.Builder(GeneratId.getId(FoodFactory.class))
                .buildDescription(description)
                .buildFoodName(foodName)
                .build();
    }
}
