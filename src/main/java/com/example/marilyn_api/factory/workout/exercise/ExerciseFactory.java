package com.example.marilyn_api.factory.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.Exercise;
import com.example.marilyn_api.util.GeneratId;
import org.hibernate.mapping.IdGenerator;

public class ExerciseFactory {
    public static Exercise getExercise(String name,int duration,String description){
        return new Exercise.Builder(GeneratId.getId(ExerciseFactory.class))
                .buildDescription(description)
                .buildDuration(duration)
                .buildName(name)
                .build();
    }
}
