package com.example.marilyn_api.service.workout;

import com.example.marilyn_api.Domain.workout.WorkOutImage;
import com.example.marilyn_api.repository.workout.WorkOutImageRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutImageService implements Iservice<WorkOutImage,String> {
    private static WorkoutImageService workoutImageService;
    private WorkOutImageRepo workOutImageRepo;

    public static WorkoutImageService getWorkoutImageService() {
        if (workoutImageService == null) {
            workoutImageService = new WorkoutImageService();
        }
        return workoutImageService;
    }

    @Override
    public WorkOutImage create(WorkOutImage workOutImage) {
        return workOutImageRepo.save(workOutImage);
    }

    @Override
    public WorkOutImage update(WorkOutImage workOutImage) {
        WorkOutImage workOutImage1 = get(workOutImage.getId());
        if (workOutImage1 != null) {
            workOutImageRepo.delete(workOutImage1);
            return create(workOutImage);
        }
        return null;
    }

    @Override
    public WorkOutImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        WorkOutImage workOutImage = get(id);
        if (workOutImage != null) {
            workOutImageRepo.delete(workOutImage);
            return true;
        }
        return false;
    }

    @Override
    public List<WorkOutImage> readAll() {
        return workOutImageRepo.findAll();
    }

    @Override
    public WorkOutImage get(String id) {
        Optional<WorkOutImage> workOutImageOptional = workOutImageRepo.findById(id);
        return workOutImageOptional.orElse(null);
    }

    /*****
     * with An
     * @param imageId
     * @return
     */
    public WorkOutImage readWithImageId(String imageId){
        for(WorkOutImage workOutImage: readAll()){
            if(workOutImage.getImageId().equals(imageId)){
                return workOutImage;
            }
        }return null;
    }

    @Override
    public List<WorkOutImage> readAllOf(String id) {
        return null;
    }
}
