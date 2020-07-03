package com.example.marilyn_api.service.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import com.example.marilyn_api.Domain.user.subscription.WorkoutSubscription;
import com.example.marilyn_api.repository.user.subscription.WorkoutSubscriptionRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutSubscriptionService implements Iservice<WorkoutSubscription,String> {
    private static WorkoutSubscriptionService workoutSubscriptionService;
    @Autowired
    private WorkoutSubscriptionRep workoutSubscriptionRep;

    public static WorkoutSubscriptionService getWorkoutSubscriptionService() {
        if (workoutSubscriptionService == null) {
            workoutSubscriptionService = new WorkoutSubscriptionService();
        }
        return workoutSubscriptionService;
    }

    @Override
    public WorkoutSubscription create(WorkoutSubscription workoutSubscription) {
        return workoutSubscriptionRep.save(workoutSubscription);
    }

    @Override
    public WorkoutSubscription update(WorkoutSubscription workoutSubscription) {
        WorkoutSubscription workoutSubscription1 = get(workoutSubscription.getId());
        if (workoutSubscription1 != null) {
            delete(workoutSubscription1.getId());
            return create(workoutSubscription);
        }
        return null;
    }

    @Override
    public WorkoutSubscription read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        WorkoutSubscription workoutSubscription1 = get(id);
        if (workoutSubscription1 != null) {
            delete(workoutSubscription1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<WorkoutSubscription> readAll() {
        return workoutSubscriptionRep.findAll();
    }

    @Override
    public WorkoutSubscription get(String id) {
        Optional<WorkoutSubscription> workoutSubscriptionOptional = workoutSubscriptionRep.findById(id);
        return workoutSubscriptionOptional.orElse(null);
    }

    @Override
    public List<WorkoutSubscription> readAllOf(String id) {
        List<WorkoutSubscription> workoutSubscriptionList = new ArrayList<>();
        for(WorkoutSubscription workoutSubscription: readAll()){
            if(workoutSubscription.getPayamentTypeId().equals(id)){
                workoutSubscriptionList.add(workoutSubscription);
            }
        }
        return workoutSubscriptionList;
    }
}
