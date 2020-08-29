package com.example.marilyn_api.controller.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.nutrition.food.FoodImageFactory;
import com.example.marilyn_api.service.nutrition.food.FoodImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("fcma/food_image/")
public class FoodImageController implements Icontroller<FoodImage,String> {
    @Autowired
    private FoodImageService foodImageService;

    @PostMapping("create")
    @Override
    public FoodImage create(@RequestBody FoodImage foodImage) throws IOException {
        FoodImage foodImage1 = FoodImageFactory.getFoodImage(foodImage.getFoodId(),foodImage.getImageId());
        return foodImageService.create(foodImage1);
    }

    @GetMapping("read")
    @Override
    public FoodImage read(@RequestParam("id") String id) {
        return foodImageService.read(id);
    }

    @PostMapping("update")
    @Override
    public FoodImage update(@RequestBody FoodImage foodImage) throws IOException {
        return foodImageService.update(foodImage);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return foodImageService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<FoodImage> readALl() {
        return foodImageService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<FoodImage> readALlOff(String id) {
        return foodImageService.readAllOf(id);
    }
}
