package com.example.marilyn_api.controller.workout;

import com.example.marilyn_api.Domain.workout.WorkVideo;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.workout.WorkoutVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/workout_video")
public class WorkOutVideoController implements Icontroller<WorkVideo,String> {
    @Autowired
    private WorkoutVideoService workoutVideoService;

    @PostMapping("create")
    @Override
    public WorkVideo create(@RequestBody WorkVideo workVideo) {
        return workoutVideoService.create(workVideo);
    }
    @GetMapping("read")
    @Override
    public WorkVideo read(@RequestParam("id") String id) {
        return workoutVideoService.read(id);
    }
    @PostMapping("update")
    @Override
    public WorkVideo update(@RequestBody WorkVideo workVideo) {
        return workoutVideoService.update(workVideo);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workoutVideoService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkVideo> readALl() {
        return workoutVideoService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<WorkVideo> readALlOff(@RequestParam("id") String id) {
        return workoutVideoService.readAllOf(id);
    }
}
