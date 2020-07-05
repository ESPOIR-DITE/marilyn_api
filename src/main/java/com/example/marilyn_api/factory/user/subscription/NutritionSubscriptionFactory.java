package com.example.marilyn_api.factory.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class NutritionSubscriptionFactory {
    public static NutritionSubscription getNutritionSubscription(double amount,Date date){
        return new NutritionSubscription.Builder(GeneratId.getId(NutritionSubscriptionFactory.class))
                .buildAmount(amount)
                .buildDate(date)
                .build();
    }
}
