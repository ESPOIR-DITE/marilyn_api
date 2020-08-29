package com.example.marilyn_api.controller.workout;

import com.example.marilyn_api.Domain.workout.WorkExercise;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.workout.WorkoutVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/workout_video")
public class WorkOutVideoController implements Icontroller<WorkExercise,String> {
    @Autowired
    private WorkoutVideoService workoutVideoService;

    @PostMapping("create")
    @Override
    public WorkExercise create(@RequestBody WorkExercise workExercise) {
        return workoutVideoService.create(workExercise);
    }
    @GetMapping("read")
    @Override
    public WorkExercise read(@RequestParam("id") String id) {
        return workoutVideoService.read(id);
    }
    @PostMapping("update")
    @Override
    public WorkExercise update(@RequestBody WorkExercise workExercise) {
        return workoutVideoService.update(workExercise);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workoutVideoService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkExercise> readALl() {
        return workoutVideoService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<WorkExercise> readALlOff(@RequestParam("id") String id) {
        return workoutVideoService.readAllOf(id);
    }
}
