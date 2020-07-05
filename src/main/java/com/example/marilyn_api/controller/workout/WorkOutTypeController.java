package com.example.marilyn_api.controller.workout;

import com.example.marilyn_api.Domain.workout.WorkoutType;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.workout.WorkOutTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/workout_type")
public class WorkOutTypeController implements Icontroller<WorkoutType,String> {
    @Autowired
    private WorkOutTypeService workOutTypeService;

    @PostMapping("create")
    @Override
    public WorkoutType create(@RequestBody WorkoutType workoutType) {
        return workOutTypeService.create(workoutType);
    }
    @GetMapping("read")
    @Override
    public WorkoutType read(@RequestParam("id") String id) {
        return workOutTypeService.read(id);
    }
    @PostMapping("update")
    @Override
    public WorkoutType update(@RequestBody WorkoutType workoutType) {
        return workOutTypeService.update(workoutType);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workOutTypeService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkoutType> readALl() {
        return workOutTypeService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<WorkoutType> readALlOff(@RequestParam("id") String id) {
        return workOutTypeService.readAllOf(id);
    }
}
