package com.example.marilyn_api.service.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import com.example.marilyn_api.repository.nutrition.NutritionRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NutritionService implements Iservice<Nutrition,String> {
    private static NutritionService nutritionService;
    @Autowired
    private NutritionRepo nutritionRepo;

    public static NutritionService getNutritionService() {
        if (nutritionService == null) {
            nutritionService = new NutritionService();
        }
        return nutritionService;
    }

    @Override
    public Nutrition create(Nutrition nutrition) {
        return nutritionRepo.save(nutrition);
    }

    @Override
    public Nutrition update(Nutrition nutrition) {
        Nutrition nutrition1 = get(nutrition.getId());
        if (nutrition1 != null) {
            delete(nutrition1.getId());
            return create(nutrition1);
        }
        return null;
    }

    @Override
    public Nutrition read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Nutrition nutrition1 = get(id);
        if (nutrition1 != null) {
            delete(nutrition1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Nutrition> readAll() {
        return nutritionRepo.findAll();
    }

    @Override
    public Nutrition get(String id) {
        Optional<Nutrition> nutritionOptional = nutritionRepo.findById(id);
        return nutritionOptional.orElse(null);
    }

    /****
     * this methos will return all the Nutrition based on typeId.
     * @param id
     * @return
     */
    @Override
    public List<Nutrition> readAllOf(String id) {
        List<Nutrition>nutritionList = new ArrayList<>();
        for(Nutrition nutrition: readAll()){
            if(nutrition.getNutritionType().equals(id)){
                nutritionList.add(nutrition);
            }
        }
        return nutritionList;
    }
}
