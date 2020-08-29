package com.example.marilyn_api.controller.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.ExerciseImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.workout.exercise.ExerciseImageFactory;
import com.example.marilyn_api.service.workout.exercise.ExerciseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/exercise_image/")
public class ExerciseImageController implements Icontroller<ExerciseImage,String> {
    @Autowired
    private ExerciseImageService exerciseImageService;

    @PostMapping
    @Override
    public ExerciseImage create(@RequestBody ExerciseImage exerciseImage) {
        ExerciseImage exerciseImage1 = ExerciseImageFactory.getExerciseImage(exerciseImage.getExerciseId(),exerciseImage.getImageId(),exerciseImage.getDescription());
        return exerciseImageService.create(exerciseImage1);
    }

    @GetMapping("read")
    @Override
    public ExerciseImage read(@RequestParam("id") String id) {
        return exerciseImageService.read(id);
    }

    @PostMapping("update")
    @Override
    public ExerciseImage update(@RequestBody ExerciseImage exerciseImage) {
        return exerciseImageService.update(exerciseImage);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return exerciseImageService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<ExerciseImage> readALl() {
        return exerciseImageService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<ExerciseImage> readALlOff(@RequestParam("id") String id) {
        return exerciseImageService.readAllOf(id);
    }
}
