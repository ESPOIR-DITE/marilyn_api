package com.example.marilyn_api.factory.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import com.example.marilyn_api.Domain.nutrition.NutritionImage;
import com.example.marilyn_api.util.GeneratId;

public class NutritionImageFactory {
    public static NutritionImage getNutrition(String imageId, String description){
        return new NutritionImage.Builder(GeneratId.getId(NutritionImageFactory.class))
        .buildDescription(description)
        .buildImageId(imageId)
        .build();
    }
}
