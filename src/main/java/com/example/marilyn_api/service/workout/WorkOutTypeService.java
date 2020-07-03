package com.example.marilyn_api.service.workout;

import com.example.marilyn_api.Domain.workout.WorkoutType;
import com.example.marilyn_api.repository.workout.WorkOutTypeRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkOutTypeService implements Iservice<WorkoutType,String> {
    private static WorkOutTypeService workOutTypeService;
    @Autowired
    private WorkOutTypeRep workOutTypeRep;

    public static WorkOutTypeService getWorkOutTypeService() {
        if (workOutTypeService == null) {
            workOutTypeService = new WorkOutTypeService();
        }
        return workOutTypeService;
    }

    @Override
    public WorkoutType create(WorkoutType workoutType) {
        return workOutTypeRep.save(workoutType);
    }

    @Override
    public WorkoutType update(WorkoutType workoutType) {
        WorkoutType workoutType1 = get(workoutType.getId());
        if (workoutType1 != null) {
            workOutTypeRep.delete(workoutType1);
            return create(workoutType);
        }
        return null;
    }

    @Override
    public WorkoutType read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        WorkoutType workoutType = get(id);
        if (workoutType != null) {
            workOutTypeRep.delete(workoutType);
            return true;
        }
        return false;
    }

    @Override
    public List<WorkoutType> readAll() {
        return workOutTypeRep.findAll();
    }

    @Override
    public WorkoutType get(String id) {
        Optional<WorkoutType> workoutType = workOutTypeRep.findById(id);
        return workoutType.orElse(null);
    }

    /****
     *
     * @param id
     * @return
     */
    @Override
    public List<WorkoutType> readAllOf(String id) {
        return null;
    }
}
