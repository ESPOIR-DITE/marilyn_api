package com.example.marilyn_api.factory.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Ingredient;
import com.example.marilyn_api.util.GeneratId;

public class IngredientFactory {
    public static Ingredient getIngredient( String ingredient,String description){
        return new Ingredient.Builder(GeneratId.getId(IngredientFactory.class))
                .buildDescription(description)
                .buildIngredient(ingredient)
                .build();
    }
}
