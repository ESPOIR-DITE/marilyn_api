package com.example.marilyn_api.controller.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Ingredient;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.nutrition.food.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/ingredient/")
public class IngredientController implements Icontroller<Ingredient,String> {
    @Autowired
    private IngredientService ingredientService;
    @PostMapping("create")
    @Override
    public Ingredient create(@RequestBody Ingredient ingredient) {
        return ingredientService.create(ingredient);
    }

    @GetMapping("read")
    @Override
    public Ingredient read(@RequestParam("id") String id) {
        return ingredientService.read(id);
    }

    @PostMapping("update")
    @Override
    public Ingredient update(@RequestBody Ingredient ingredient) {
        return ingredientService.update(ingredient);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return ingredientService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<Ingredient> readALl() {
        return ingredientService.readAll();
    }


    @Override
    public List<Ingredient> readALlOff(String id) {
        return ingredientService.readAllOf(id);
    }
}
