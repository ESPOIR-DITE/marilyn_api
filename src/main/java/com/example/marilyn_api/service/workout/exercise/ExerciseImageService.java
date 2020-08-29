package com.example.marilyn_api.service.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.ExerciseImage;
import com.example.marilyn_api.repository.workout.exercise.ExerciseImageRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseImageService implements Iservice<ExerciseImage,String> {
    @Autowired
    private ExerciseImageRepo exerciseImageRepo;

    private static ExerciseService exerciseService;

    public static ExerciseService getExerciseService() {
        if (exerciseService == null) {
            exerciseService = new ExerciseService();
        }
        return exerciseService;
    }

    @Override
    public ExerciseImage create(ExerciseImage exerciseImage) {
        return exerciseImageRepo.save(exerciseImage);
    }

    @Override
    public ExerciseImage update(ExerciseImage exerciseImage) {
        ExerciseImage exerciseImage1 = get(exerciseImage.getId());
        if (exerciseImage1 != null) {
            return exerciseImageRepo.save(exerciseImage);
        }
        return null;
    }

    @Override
    public ExerciseImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        ExerciseImage exerciseImage1 = get(id);
        if (exerciseImage1 != null) {
            exerciseImageRepo.delete(exerciseImage1);
            return true;
        }
        return false;
    }

    @Override
    public List<ExerciseImage> readAll() {
        return exerciseImageRepo.findAll();
    }

    @Override
    public ExerciseImage get(String id) {
        Optional<ExerciseImage> exerciseImageOptional = exerciseImageRepo.findById(id);
        return exerciseImageOptional.orElse(null);
    }

    @Override
    public List<ExerciseImage> readAllOf(String id) {
        List<ExerciseImage> exerciseImageList = new ArrayList<>();
        for (ExerciseImage exerciseImage:readAll()){
            if(exerciseImage.getExerciseId().equals(id)){
                exerciseImageList.add(exerciseImage);
            }
        }
        return exerciseImageList;
    }
}
