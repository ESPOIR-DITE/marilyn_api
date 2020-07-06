package com.example.marilyn_api.controller.user.sudscrition;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.user.subscription.NutritionSubscriptionFactory;
import com.example.marilyn_api.service.user.subscription.NutritionSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/nutrition_subscription/")
public class NutritionSubscriptionController implements Icontroller<NutritionSubscription,String> {
    @Autowired
    private NutritionSubscriptionService nutritionSubscriptionService;

    @PostMapping("create")
    @Override
    public NutritionSubscription create(@RequestBody NutritionSubscription nu) {
        NutritionSubscription nutritionSubscription1 = NutritionSubscriptionFactory.getNutritionSubscription(nu.getAmount(),nu.getDate());
        return nutritionSubscriptionService.create(nutritionSubscription1);
    }
    @GetMapping("read")
    @Override
    public NutritionSubscription read(@RequestParam("id") String id) {
        return nutritionSubscriptionService.read(id);
    }
    @PostMapping("update")
    @Override
    public NutritionSubscription update(@RequestBody NutritionSubscription nutritionSubscription) {
        return nutritionSubscriptionService.update(nutritionSubscription);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return nutritionSubscriptionService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<NutritionSubscription> readALl() {
        return nutritionSubscriptionService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<NutritionSubscription> readALlOff(String id) {
        return nutritionSubscriptionService.readAllOf(id);
    }
}
