package com.example.marilyn_api.service.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.Exercise;
import com.example.marilyn_api.repository.workout.exercise.ExerciseRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService implements Iservice<Exercise,String> {
    @Autowired
    private ExerciseRepo exerciseRepo;

    private static ExerciseService exerciseService;

    public static ExerciseService getExerciseService() {
        if (exerciseService == null) {
            exerciseService = new ExerciseService();
        }return exerciseService;
    }

    @Override
    public Exercise create(Exercise exercise) {
        return exerciseRepo.save(exercise);
    }

    @Override
    public Exercise update(Exercise exercise) {
        Exercise exercise1 = get(exercise.getId());
        if (exercise1 != null) {
            return exerciseRepo.save(exercise);
        }
        return null;
    }

    @Override
    public Exercise read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Exercise exercise1 = get(id);
        if (exercise1 != null) {
            exerciseRepo.delete(exercise1);
            return true;
        }
        return false;
    }

    @Override
    public List<Exercise> readAll() {
        return exerciseRepo.findAll();
    }

    @Override
    public Exercise get(String id) {
        Optional<Exercise> exerciseOptional = exerciseRepo.findById(id);
        return exerciseOptional.orElse(null);
    }

    @Override
    public List<Exercise> readAllOf(String id) {
        return null;
    }
}
