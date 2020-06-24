package com.example.marilyn_api.factory.workout;

import com.example.marilyn_api.Domain.workout.WorkoutType;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class WorkOutTypeFactory {
    public static WorkoutType getWorkoutType(String workOutType,Date date){
        return new WorkoutType.Builder(GeneratId.getId( WorkOutTypeFactory.class))
                .buildDate(date)
                .buildWorkOutType(workOutType)
                .build();
    }
}
