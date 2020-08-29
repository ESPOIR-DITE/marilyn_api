package com.example.marilyn_api.factory.workout;

import com.example.marilyn_api.Domain.workout.WorkExercise;
import com.example.marilyn_api.util.GeneratId;

public class WorkExerciseFactory {
    public static WorkExercise getWorkVideo(String workOutId, String exerciseId, String description){
        return new WorkExercise.Builder(GeneratId.getId(WorkExerciseFactory.class))
                .buildDescription(description)
                .buildExerciseId(exerciseId)
                .buildWorkoutId(workOutId)
                .build();
    }
}
