package com.example.marilyn_api.factory.workout;

import com.example.marilyn_api.Domain.workout.WorkOut;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class WorkOutFactory {
    public static WorkOut getWorkOut(String workoutTypeId,String description,Date date){
        return new WorkOut.Builder(GeneratId.getId(WorkOutFactory.class))
                .buildDate(date).builDescription(description).buildWorkoutTypeId(workoutTypeId).build();
    }
}
