package com.example.marilyn_api.service.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import com.example.marilyn_api.Domain.nutrition.NutritionImage;
import com.example.marilyn_api.repository.nutrition.NutritionImageRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionImageService implements Iservice<NutritionImage,String> {
    private static NutritionImageService nutritionImageService;
    @Autowired
    private NutritionImageRep nutritionImageRep;

    public static NutritionImageService getNutritionImageService() {
        if (nutritionImageService != null) {
            nutritionImageService = new  NutritionImageService();
        }
        return nutritionImageService;
    }

    @Override
    public NutritionImage create(NutritionImage nutritionImage) {
        return nutritionImageRep.save(nutritionImage);
    }

    @Override
    public NutritionImage update(NutritionImage nutritionImage) {
        NutritionImage nutritionImage1 = get(nutritionImage.getId());
        if (nutritionImage1 != null) {
            delete(nutritionImage1.getId());
            return create(nutritionImage);
        }
        return null;
    }

    @Override
    public NutritionImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        NutritionImage nutritionImage1 = get(id);
        if (nutritionImage1 != null) {
            delete(nutritionImage1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<NutritionImage> readAll() {
        return nutritionImageRep.findAll();
    }

    @Override
    public NutritionImage get(String id) {
        Optional<NutritionImage> nutritionImageOptional = nutritionImageRep.findById(id);
        return nutritionImageOptional.orElse(null);
    }

    @Override
    public List<NutritionImage> readAllOf(String id) {
        return null;
    }

    /****
     * Reading nutrition based on the nutritionId
     * @param nutritionType
     * @return
     */
    public NutritionImage readWithNutrition(String nutritionType){
        for(NutritionImage nutritionImage: readAll()){
            if(nutritionImage.getImageId().equals(nutritionType)){
                return nutritionImage;
            }
        }return null;
    }
}
