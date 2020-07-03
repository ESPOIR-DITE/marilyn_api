package com.example.marilyn_api.service.workout;

import com.example.marilyn_api.Domain.workout.WorkOut;
import com.example.marilyn_api.repository.workout.WorkoutRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkOutService implements Iservice<WorkOut,String> {
    private static WorkOutService workOutService;
    @Autowired
    private WorkoutRep workoutRep;

    public static WorkOutService getWorkOutService() {
        if (workOutService == null) {
            workOutService = new WorkOutService();
        }
        return workOutService;
    }

    @Override
    public WorkOut create(WorkOut workOut) {
        return workoutRep.save(workOut);
    }

    @Override
    public WorkOut update(WorkOut workOut) {
        WorkOut workOut1 = get(workOut.getId());
        if (workOut1 != null) {
            workoutRep.delete(workOut1);
            return create(workOut);
        }
        return null;
    }

    @Override
    public WorkOut read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        WorkOut workOut1 = get(id);
        if (workOut1 != null) {
            workoutRep.delete(workOut1);
            return true;
        }
        return false;
    }

    @Override
    public List<WorkOut> readAll() {
        return workoutRep.findAll();
    }

    @Override
    public WorkOut get(String id) {
        Optional<WorkOut> workOutOptional = workoutRep.findById(id);
        return workOutOptional.orElse(null);
    }

    @Override
    public List<WorkOut> readAllOf(String id) {
        return null;
    }
}
