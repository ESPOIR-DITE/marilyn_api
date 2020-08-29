package com.example.marilyn_api.factory.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodImage;
import com.example.marilyn_api.util.GeneratId;

public class FoodImageFactory {
    public static FoodImage getFoodImage(String foodId,String imageId){
        return new FoodImage.Builder(GeneratId.getId(FoodImageFactory.class))
                .buildImageId(imageId)
                .buildFoodId(foodId)
                .build();
    }
}
