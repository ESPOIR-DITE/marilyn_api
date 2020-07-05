package com.example.marilyn_api.controller.workout;

import com.example.marilyn_api.Domain.workout.WorkOutPlan;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.workout.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/workout_plan")
public class WorkoutPlanController implements Icontroller<WorkOutPlan,String> {
    @Autowired
    private WorkoutPlanService workoutPlanService;

    @PostMapping("create")
    @Override
    public WorkOutPlan create(WorkOutPlan workOutPlan) {
        return workoutPlanService.create(workOutPlan);
    }
    @GetMapping("read")
    @Override
    public WorkOutPlan read(@RequestParam("id") String id) {
        return workoutPlanService.read(id);
    }@PostMapping("update")
    @Override
    public WorkOutPlan update(@RequestBody WorkOutPlan workOutPlan) {
        return workoutPlanService.update(workOutPlan);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workoutPlanService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkOutPlan> readALl() {
        return workoutPlanService.readAll();
    }
@GetMapping("readAllOff")
    @Override
    public List<WorkOutPlan> readALlOff(String id) {
        return workoutPlanService.readAllOf(id);
    }
}
