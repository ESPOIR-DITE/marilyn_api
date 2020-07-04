package com.example.marilyn_api.controller.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.nutrition.NutritionFactory;
import com.example.marilyn_api.service.nutrition.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("fcma/nutrition/")
public class NutritionController implements Icontroller<Nutrition,String> {
    @Autowired
    private NutritionService nutritionService;
    @PostMapping("create")
    @Override
    public Nutrition create(@RequestBody Nutrition nutrition) {
        Nutrition nutrition1 = NutritionFactory.getNutrition(nutrition.getNutritionType(),nutrition.getName(),nutrition.getDescription(),nutrition.getPrice());
        return nutritionService.create(nutrition1);
    }

    @GetMapping("read")
    @Override
    public Nutrition read(@RequestParam("id") String id) {
        return nutritionService.read(id);
    }

    @PostMapping("update")
    @Override
    public Nutrition update(@RequestBody Nutrition nutrition) {
        return nutritionService.update(nutrition);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return nutritionService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<Nutrition> readALl() {
        return nutritionService.readAll();
    }
    /****
     * this methos will return all the Nutrition based on typeId.
     * @param id
     * @return
     */
    @GetMapping("readAllOf")
    @Override
    public List<Nutrition> readALlOff(@RequestParam("id") String id) {
        return nutritionService.readAllOf(id);
    }
}
