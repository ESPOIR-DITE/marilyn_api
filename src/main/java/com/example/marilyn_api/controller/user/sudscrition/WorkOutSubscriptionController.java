package com.example.marilyn_api.controller.user.sudscrition;

import com.example.marilyn_api.Domain.user.subscription.WorkoutSubscription;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.subscription.WorkoutSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/WorkOutSubscription")
public class WorkOutSubscriptionController implements Icontroller<WorkoutSubscription,String> {
    @Autowired
    private WorkoutSubscriptionService workoutSubscriptionService;

    @PostMapping("create")
    @Override
    public WorkoutSubscription create(@RequestBody WorkoutSubscription workoutSubscription) {
        return workoutSubscriptionService.create(workoutSubscription);
    }
    @GetMapping("read")
    @Override
    public WorkoutSubscription read(@RequestParam("read") String id) {
        return workoutSubscriptionService.read(id);
    }
    @PostMapping("update")
    @Override
    public WorkoutSubscription update(@RequestBody WorkoutSubscription workoutSubscription) {
        return workoutSubscriptionService.update(workoutSubscription);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return workoutSubscriptionService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<WorkoutSubscription> readALl() {
        return workoutSubscriptionService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<WorkoutSubscription> readALlOff(String id) {
        return workoutSubscriptionService.readAllOf(id);
    }
}
