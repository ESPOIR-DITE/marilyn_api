package com.example.marilyn_api.controller.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.Exercise;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.workout.exercise.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/exercise/")
public class ExerciseController implements Icontroller<Exercise,String> {
    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("create")
    @Override
    public Exercise create(@RequestBody Exercise exercise) {
        return exerciseService.create(exercise);
    }

    @GetMapping("read")
    @Override
    public Exercise read(@RequestParam("id") String id) {
        return exerciseService.read(id);
    }

    @PostMapping("update")
    @Override
    public Exercise update(@RequestBody Exercise exercise) {
        return exerciseService.update(exercise);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return exerciseService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Exercise> readALl() {
        return exerciseService.readAll();
    }

    @Override
    public List<Exercise> readALlOff(String id) {
        return null;
    }
}
