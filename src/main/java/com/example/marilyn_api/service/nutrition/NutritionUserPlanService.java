package com.example.marilyn_api.service.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionUserPlan;
import com.example.marilyn_api.repository.nutrition.NutritionUserPlanRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionUserPlanService  implements Iservice<NutritionUserPlan,String> {
    private static NutritionUserPlanService nutritionUserPlanService;
    @Autowired
    private NutritionUserPlanRep nutritionUserPlanRep;

    public static NutritionUserPlanService getNutritionUserPlanService() {
        if (nutritionUserPlanService == null) {
            nutritionUserPlanService = new NutritionUserPlanService();
        }
        return nutritionUserPlanService;
    }

    @Override
    public NutritionUserPlan create(NutritionUserPlan nutritionUserPlan) {
        return nutritionUserPlanRep.save(nutritionUserPlan);
    }

    @Override
    public NutritionUserPlan update(NutritionUserPlan nutritionUserPlan) {
        NutritionUserPlan nutritionUserPlan1 = get(nutritionUserPlan.getId());
        if (nutritionUserPlan1 != null) {
            delete(nutritionUserPlan1.getId());
            return create(nutritionUserPlan);
        }
        return null;
    }

    @Override
    public NutritionUserPlan read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        NutritionUserPlan nutritionUserPlan1 = get(id);
        if (nutritionUserPlan1 != null) {
            nutritionUserPlanRep.delete(nutritionUserPlan1);
            return true;
        }
        return false;
    }

    @Override
    public List<NutritionUserPlan> readAll() {
        return nutritionUserPlanRep.findAll();
    }

    @Override
    public NutritionUserPlan get(String id) {
        Optional<NutritionUserPlan> nutritionUserPlanOptional = nutritionUserPlanRep.findById(id);
        return nutritionUserPlanOptional.orElse(null);
    }

    /****
     * Will return all the plans of a user based on .
     * @param id
     * @return
     */
    @Override
    public List<NutritionUserPlan> readAllOf(String id) {
        return null;
    }
}
