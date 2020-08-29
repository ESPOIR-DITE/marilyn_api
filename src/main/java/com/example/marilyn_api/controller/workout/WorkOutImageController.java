package com.example.marilyn_api.controller.workout;

import com.example.marilyn_api.Domain.workout.WorkOutImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.workout.WorkoutImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/workout_image")
public class WorkOutImageController implements Icontroller<WorkOutImage,String> {
    @Autowired
    private WorkoutImageService workoutImageService;
    @PostMapping("create")
    @Override
    public WorkOutImage create(WorkOutImage workOutImage) {
        return workoutImageService.create(workOutImage);
    }
    @GetMapping("read")
    @Override
    public WorkOutImage read(@RequestParam("id") String id) {
        return workoutImageService.read(id);
    }
    @PostMapping("update")
    @Override
    public WorkOutImage update(@RequestBody WorkOutImage workOutImage) {
        return workoutImageService.update(workOutImage);
    }@GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workoutImageService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkOutImage> readALl() {
        return workoutImageService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<WorkOutImage> readALlOff(@RequestParam("id") String id) {
        return workoutImageService.readAllOf(id);
    }
}
