package com.example.marilyn_api.service.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionVideo;
import com.example.marilyn_api.repository.nutrition.NutritionVideoRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionVideoService  implements Iservice<NutritionVideo,String> {
    private static NutritionVideoService nutritionVideoService;
    @Autowired
    private NutritionVideoRep nutritionVideoRep;

    public static NutritionVideoService getNutritionVideoService() {
        if (nutritionVideoService == null) {
            nutritionVideoService = new NutritionVideoService();
        }
        return nutritionVideoService;
    }
    @Override
    public NutritionVideo create(NutritionVideo nutritionVideo) {
        return nutritionVideoRep.save(nutritionVideo);
    }
    @Override
    public NutritionVideo update(NutritionVideo nutritionVideo) {
        NutritionVideo nutritionVideo1 = get(nutritionVideo.getId());
        if (nutritionVideo1 != null) {
            nutritionVideoRep.delete(nutritionVideo1);
            return create(nutritionVideo);
        }
        return null;
    }
    @Override
    public NutritionVideo read(String id) {
        return get(id);
    }
    @Override
    public Boolean delete(String id) {
        NutritionVideo nutritionVideo1 = get(id);
        if (nutritionVideo1 != null) {
            delete(nutritionVideo1.getId());
            return true;
        }
        return false;
    }
    @Override
    public List<NutritionVideo> readAll() {
        return nutritionVideoRep.findAll();
    }
    @Override
    public NutritionVideo get(String id) {
        Optional<NutritionVideo> nutritionVideoOptional = nutritionVideoRep.findById(id);
        return nutritionVideoOptional.orElse(null);
    }
    @Override
    public List<NutritionVideo> readAllOf(String id) {
        return null;
    }

    /*****
     * with nutritionId you can get NutritionVideo
     * @param id
     * @return
     */
    public NutritionVideo readWithNutrition(String id){
        for(NutritionVideo nutritionVideo: readAll()){
            if(nutritionVideo.getNutritionId().equals(id)){
                return nutritionVideo;
            }
        }return null;
    }
}
