package com.example.marilyn_api.controller.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionUserPlan;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.nutrition.NutritionUserPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/nutrition_user_plane/")
public class NutritionUserPlanController implements Icontroller<NutritionUserPlan,String> {
    @Autowired
    private NutritionUserPlanService nutritionUserPlanService;
    @PostMapping("create")
    @Override
    public NutritionUserPlan create(@RequestBody NutritionUserPlan nutritionUserPlan) {
        return nutritionUserPlanService.create(nutritionUserPlan);
    }
    @GetMapping("read")
    @Override
    public NutritionUserPlan read(@RequestParam("id") String id) {
        return nutritionUserPlanService.read(id);
    }
    @PostMapping("update")
    @Override
    public NutritionUserPlan update(@RequestBody NutritionUserPlan nutritionUserPlan) {
        return nutritionUserPlanService.update(nutritionUserPlan);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return nutritionUserPlanService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<NutritionUserPlan> readALl() {
        return nutritionUserPlanService.readAll();
    }
    @GetMapping("readAllOf")
    @Override
    public List<NutritionUserPlan> readALlOff(String id) {
        return nutritionUserPlanService.readAllOf(id);
    }
    @GetMapping("readWithNutrition")
    public NutritionUserPlan readWithNutrition(String nutritionId){
        return nutritionUserPlanService.readWithNutritionId(nutritionId);
    }
    @GetMapping("readWithSubscription")
    public NutritionUserPlan readWithSubscription(String subscriptionId){
        return nutritionUserPlanService.readWithSubscriptionId(subscriptionId);
    }
}
