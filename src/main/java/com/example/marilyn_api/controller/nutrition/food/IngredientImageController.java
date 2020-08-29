package com.example.marilyn_api.controller.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.IngredientImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.nutrition.food.IngredientImageFactory;
import com.example.marilyn_api.service.nutrition.food.IngredientImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("fcma/ingredient_image/")
public class IngredientImageController implements Icontroller<IngredientImage,String> {
    @Autowired
    private IngredientImageService ingredientImageService;
    @PostMapping("create")
    @Override
    public IngredientImage create(@RequestBody IngredientImage ingredientImage) {
        IngredientImage ingredientImage1 = IngredientImageFactory.getIngredientImage(ingredientImage.getIngredientId(),ingredientImage.getImageId());
        return ingredientImageService.create(ingredientImage1);
    }
    @GetMapping("read")
    @Override
    public IngredientImage read(@RequestParam("id") String id) {
        return ingredientImageService.read(id);
    }
    @PostMapping("update")
    @Override
    public IngredientImage update(@RequestBody IngredientImage ingredientImage) {
        return ingredientImageService.update(ingredientImage);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return ingredientImageService.delete(id);
    }
    @GetMapping("reads")
    @Override
    public List<IngredientImage> readALl() {
        return ingredientImageService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<IngredientImage> readALlOff(@RequestParam("id") String id) {
        return ingredientImageService.readAllOf(id);
    }
    @GetMapping("readOf")
    public IngredientImage readOf(@RequestParam("id") String id) {
        return ingredientImageService.readOf(id);
    }

}
