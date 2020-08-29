package com.example.marilyn_api.factory.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import com.example.marilyn_api.Domain.user.subscription.WorkoutSubscription;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class WorkoutSubscriptionFactory {
    private WorkoutSubscription getNutritionSubscription(Date date,String workoutPlanId,String email,String paymentTypeId){
        return new WorkoutSubscription.Builder(GeneratId.getId(NutritionSubscriptionFactory.class))
                .buildEmail(email)
                .buildWorkoutPlanId(workoutPlanId)
                .buildDate(date)
                .buildPaymentTypeId(paymentTypeId)
                .build();
    }
}
