package com.example.marilyn_api.factory.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.IngredientImage;
import com.example.marilyn_api.util.GeneratId;

public class IngredientImageFactory {
    public static IngredientImage getIngredientImage(String ingredientId,String imageId){
        return new IngredientImage.Builder(GeneratId.getId(IngredientImage.class))
                .buildImageId(imageId)
                .buildIngredientId(ingredientId)
                .build();
    }
}
