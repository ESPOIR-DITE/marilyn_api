package com.example.marilyn_api.service.workout;

import com.example.marilyn_api.Domain.workout.WorkVideo;
import com.example.marilyn_api.repository.workout.WorkOutVideoRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutVideoService implements Iservice<WorkVideo,String> {
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
    public WorkVideo create(WorkVideo workVideo) {
        return workOutVideoRep.save(workVideo);
    }

    @Override
    public WorkVideo update(WorkVideo workVideo) {
        WorkVideo workVideo1 = get(workVideo.getId());
        if (workVideo1 != null) {
            workOutVideoRep.delete(workVideo1);
            return create(workVideo);
        }
        return null;
    }

    @Override
    public WorkVideo read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        WorkVideo workVideo1 = get(id);
        if (workVideo1 != null) {
            workOutVideoRep.delete(workVideo1);
            return true;
        }
        return false;
    }

    @Override
    public List<WorkVideo> readAll() {
        return workOutVideoRep.findAll();
    }

    @Override
    public WorkVideo get(String id) {
        Optional<WorkVideo> workVideOptional = workOutVideoRep.findById(id);
        return workVideOptional.orElse(null);
    }

    @Override
    public List<WorkVideo> readAllOf(String id) {
        return null;
    }

}
