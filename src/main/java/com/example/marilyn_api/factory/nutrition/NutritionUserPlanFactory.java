package com.example.marilyn_api.factory.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionUserPlan;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class NutritionUserPlanFactory {
    public static NutritionUserPlan getNutritionUserPlan(String email,String nutritionId,String subdscriptionid,Date date){
        return new NutritionUserPlan.Builder(GeneratId.getId(NutritionUserPlanFactory.class))
                .buildDate(date)
                .buildEmail(email)
                .buildNutrition(nutritionId)
                .buildSubscriptionId(subdscriptionid)
                .build();
    }
}
