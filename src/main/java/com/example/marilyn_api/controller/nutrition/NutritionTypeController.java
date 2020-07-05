package com.example.marilyn_api.controller.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionType;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.nutrition.NutritionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/nutrition_type/")
public class NutritionTypeController implements Icontroller<NutritionType,String> {
    @Autowired
    private NutritionTypeService nutritionTypeService;
    @PostMapping("create")
    @Override
    public NutritionType create(@RequestBody NutritionType nutritionType) {
        return nutritionTypeService.create(nutritionType);
    }

    @GetMapping("read")
    @Override
    public NutritionType read(@RequestParam("id") String id) {
        return nutritionTypeService.read(id);
    }

    @PostMapping("update")
    @Override
    public NutritionType update(@RequestBody NutritionType nutritionType) {
        return nutritionTypeService.update(nutritionType);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return nutritionTypeService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<NutritionType> readALl() {
        return nutritionTypeService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<NutritionType> readALlOff(String id) {
        return nutritionTypeService.readAllOf(id);
    }
}
