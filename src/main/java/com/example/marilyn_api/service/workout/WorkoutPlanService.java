package com.example.marilyn_api.service.workout;

import com.example.marilyn_api.Domain.workout.WorkOutPlan;
import com.example.marilyn_api.repository.workout.WorkOutPlanRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanService implements Iservice<WorkOutPlan,String> {
    @Autowired
    private WorkOutPlanRep workOutPlanRep;
    private static WorkoutPlanService workoutPlanService;

    public static WorkoutPlanService getWorkoutPlanService() {
        if (workoutPlanService == null) {
            workoutPlanService= new WorkoutPlanService();
        }
        return workoutPlanService;
    }

    @Override
    public WorkOutPlan create(WorkOutPlan workOutPlan) {
        return workOutPlanRep.save(workOutPlan);
    }

    @Override
    public WorkOutPlan update(WorkOutPlan workOutPlan) {
        WorkOutPlan workOutPlan1 = get(workOutPlan.getId());
        if (workOutPlan1 != null) {
            workOutPlanRep.delete(workOutPlan1);
            return create(workOutPlan);
        }
        return null;
    }

    @Override
    public WorkOutPlan read(String id) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        WorkOutPlan workOutPlan1 = get(id);
        if (workOutPlan1 != null) {
            workOutPlanRep.delete(workOutPlan1);
            return true;
        }
        return false;
    }

    @Override
    public List<WorkOutPlan> readAll() {
        return workOutPlanRep.findAll();
    }

    @Override
    public WorkOutPlan get(String id) {
        Optional<WorkOutPlan> workOutPlan = workOutPlanRep.findById(id);
        return workOutPlan.orElse(null);
    }

    @Override
    public List<WorkOutPlan> readAllOf(String id) {
        return null;
    }
    /***
     * get a workoutPlane with a subscriptionId
     */
    public WorkOutPlan getWithSubscriptionId(String subscriptionId){
        for(WorkOutPlan workOutPlan: readAll()){
            if(workOutPlan.getSubscriptionId().equals(subscriptionId)){
                return workOutPlan;
            }
        }return null;
    }
}
