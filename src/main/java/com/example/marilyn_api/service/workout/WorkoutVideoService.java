package com.example.marilyn_api.service.workout;

import com.example.marilyn_api.Domain.workout.WorkExercise;
import com.example.marilyn_api.repository.workout.WorkOutVideoRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutVideoService implements Iservice<WorkExercise,String> {
    private static WorkoutVideoService workoutVideoService;
    @Autowired
    private WorkOutVideoRep workOutVideoRep;

    public static WorkoutVideoService getWorkoutVideoService() {
        if (workoutVideoService == null) {
            workoutVideoService = new WorkoutVideoService();
        }
        return workoutVideoService;
    }

    @Override
    public WorkExercise create(WorkExercise workExercise) {
        return workOutVideoRep.save(workExercise);
    }

    @Override
    public WorkExercise update(WorkExercise workExercise) {
        WorkExercise workExercise1 = get(workExercise.getId());
        if (workExercise1 != null) {
            workOutVideoRep.delete(workExercise1);
            return create(workExercise);
        }
        return null;
    }

    @Override
    public WorkExercise read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        WorkExercise workExercise1 = get(id);
        if (workExercise1 != null) {
            workOutVideoRep.delete(workExercise1);
            return true;
        }
        return false;
    }

    @Override
    public List<WorkExercise> readAll() {
        return workOutVideoRep.findAll();
    }

    @Override
    public WorkExercise get(String id) {
        Optional<WorkExercise> workVideOptional = workOutVideoRep.findById(id);
        return workVideOptional.orElse(null);
    }

    @Override
    public List<WorkExercise> readAllOf(String id) {
        return null;
    }

}
