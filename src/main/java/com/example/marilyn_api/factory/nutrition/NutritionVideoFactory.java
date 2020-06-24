package com.example.marilyn_api.factory.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionVideo;
import com.example.marilyn_api.util.GeneratId;

public class NutritionVideoFactory {
    public static NutritionVideo getNutritionVideo(String videoId,String nutritionId,String descrition){
        return new NutritionVideo.Builder(GeneratId.getId(NutritionVideoFactory.class))
                .buildDescription(descrition)
                .buildNutritionId(nutritionId)
                .buildVideoId(videoId)
                .build();
    }
}
