package com.example.marilyn_api.controller.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Food;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.nutrition.food.FoodFactory;
import com.example.marilyn_api.service.nutrition.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/food/")
public class FoodController implements Icontroller<Food,String> {
    @Autowired
    private FoodService foodService;

    @PostMapping("create")
    @Override
    public Food create(@RequestBody Food food) {
        Food food1 = FoodFactory.getFood(food.getFoodName(),food.getDescription());
        return foodService.create(food1);
    }

    @GetMapping("read")
    @Override
    public Food read(@RequestParam("id") String id) {
        return foodService.read(id);
    }

    @PostMapping("update")
    @Override
    public Food update(@RequestBody Food food) {
        return foodService.update(food);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return foodService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<Food> readALl() {
        return foodService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<Food> readALlOff(@RequestParam("id") String id) {
        return foodService.readAllOf(id);
    }
}
