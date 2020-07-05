package com.example.marilyn_api.controller.workout;

import com.example.marilyn_api.Domain.workout.WorkOut;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.workout.WorkOutFactory;
import com.example.marilyn_api.service.workout.WorkOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/workout")
public class WorkoutController implements Icontroller<WorkOut,String> {
    @Autowired
    private WorkOutService workOutService;

    @Override
    public WorkOut create(@RequestBody WorkOut workOut) {
        WorkOut workOut1 = WorkOutFactory.getWorkOut(workOut.getWorkoutTypeId(),workOut.getDescription(),workOut.getDate());
        return workOutService.create(workOut1);
    }
    @GetMapping("read")
    @Override
    public WorkOut read(@RequestParam("id") String id) {
        return workOutService.read(id);
    }
    @PostMapping("update")
    @Override
    public WorkOut update(@RequestBody WorkOut workOut) {
        return workOutService.update(workOut);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workOutService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkOut> readALl() {
        return workOutService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<WorkOut> readALlOff(String id) {
        return workOutService.readAllOf(id);
    }
}
