package com.example.marilyn_api.controller.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import com.example.marilyn_api.Domain.nutrition.NutritionImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.nutrition.NutritionImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/nutrition_image/")
public class NutritionImageController implements Icontroller<NutritionImage,String> {
    @Autowired
    private NutritionImageService nutritionImageService;
    @PostMapping("read")
    @Override
    public NutritionImage create(@RequestBody NutritionImage nutritionImage) {
        return nutritionImageService.create(nutritionImage);
    }

    @GetMapping("read")
    @Override
    public NutritionImage read(@RequestParam("id") String id) {
        return nutritionImageService.read(id);
    }

    @PostMapping("update")
    @Override
    public NutritionImage update(@RequestBody NutritionImage nutritionImage) {
        return nutritionImageService.update(nutritionImage);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return nutritionImageService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<NutritionImage> readALl() {
        return nutritionImageService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<NutritionImage> readALlOff(String id) {
        return nutritionImageService.readAllOf(id);
    }
}
