package com.example.marilyn_api.factory.workout;

import com.example.marilyn_api.Domain.workout.WorkOutImage;
import com.example.marilyn_api.util.GeneratId;

public class WorkOutImageFactory {
    public static WorkOutImage getWorkOutImage(String workOutId,String imageId){
        return new WorkOutImage.Builder(GeneratId.getId(WorkOutImage.class))
                .buildImageId(imageId)
                .buildWorkOut(workOutId)
                .build();
    }
}
