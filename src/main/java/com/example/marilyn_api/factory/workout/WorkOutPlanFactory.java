package com.example.marilyn_api.factory.workout;

import com.example.marilyn_api.Domain.workout.WorkOutPlan;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class WorkOutPlanFactory {
    public WorkOutPlan getWorkOut(String email,String subscriptionId,Date date){
        return new WorkOutPlan.Builder(GeneratId.getId(WorkOutPlanFactory.class))
                .buildDate(date)
                .buildEmail(email)
                .buildSubscription(subscriptionId)
                .build();
    }
}
