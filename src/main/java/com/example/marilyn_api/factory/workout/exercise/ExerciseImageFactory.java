package com.example.marilyn_api.factory.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.ExerciseImage;
import com.example.marilyn_api.util.GeneratId;

public class ExerciseImageFactory {
    public static ExerciseImage getExerciseImage(String exerciseId,String imageId,String description){
        return new ExerciseImage.Builder(GeneratId.getId(ExerciseImageFactory.class))
                .buildDescription(description)
                .buildExerciseId(exerciseId)
                .ImageId(imageId)
                .build();
    }
}
