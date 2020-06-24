package com.example.marilyn_api.factory.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import com.example.marilyn_api.Domain.user.subscription.WorkoutSubscription;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class WorkoutSubscriptionFactory {
    private WorkoutSubscription getNutritionSubscription(double amount, Date date){
        return new WorkoutSubscription.Builder(GeneratId.getId(NutritionSubscriptionFactory.class))
                .buildAmount(amount)
                .buildDate(date)
                .build();
    }
}
