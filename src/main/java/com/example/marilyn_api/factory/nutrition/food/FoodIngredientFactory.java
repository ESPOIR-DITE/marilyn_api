package com.example.marilyn_api.factory.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodIngredient;
import com.example.marilyn_api.util.GeneratId;

public class FoodIngredientFactory {
    public static FoodIngredient getFoodIngredient(String foodId,String ingredientId,String description){
        return  new FoodIngredient.Builder(GeneratId.getId(FoodIngredientFactory.class))
                .buildDescription(description)
                .buildFoodId(foodId)
                .buildIngredientId(ingredientId)
                .build();
    }
}
