package com.example.marilyn_api.factory.workout;

import com.example.marilyn_api.Domain.workout.WorkVideo;
import com.example.marilyn_api.util.GeneratId;

public class WorkVideoFactory {
    public static WorkVideo getWorkVideo(String workOutId,String description){
        return new WorkVideo.Builder(GeneratId.getId(WorkVideoFactory.class))
                .buildDescription(description)
                .buildWorkoutId(workOutId)
                .build();
    }
}
