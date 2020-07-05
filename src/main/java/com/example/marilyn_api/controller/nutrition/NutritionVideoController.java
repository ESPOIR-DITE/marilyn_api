package com.example.marilyn_api.controller.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionVideo;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.nutrition.NutritionVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/nutrition_video/")
public class NutritionVideoController implements Icontroller<NutritionVideo,String> {
    @Autowired
    private NutritionVideoService nutritionVideoService;

    @PostMapping("create")
    @Override
    public NutritionVideo create(@RequestBody NutritionVideo nutritionVideo) {
        return nutritionVideoService.create(nutritionVideo);
    }
    @GetMapping("read")
    @Override
    public NutritionVideo read(@RequestParam("id") String id) {
        return nutritionVideoService.read(id);
    }
    @PostMapping("update")
    @Override
    public NutritionVideo update(NutritionVideo nutritionVideo) {
        return nutritionVideoService.update(nutritionVideo);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(String id) {
        return nutritionVideoService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<NutritionVideo> readALl() {
        return nutritionVideoService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<NutritionVideo> readALlOff(String id) {
        return nutritionVideoService.readAllOf(id);
    }
    @GetMapping("readWithNutrition")
    public NutritionVideo readWithNutrition(@RequestParam("id") String nutritionId){
        return nutritionVideoService.readWithNutrition(nutritionId);
    }
}
