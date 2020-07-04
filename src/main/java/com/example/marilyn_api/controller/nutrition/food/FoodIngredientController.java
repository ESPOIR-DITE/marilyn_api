package com.example.marilyn_api.controller.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodIngredient;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.nutrition.food.FoodIngredientFactory;
import com.example.marilyn_api.service.nutrition.food.FoodIngredientService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/food_ingredient/")
public class FoodIngredientController implements Icontroller<FoodIngredient,String> {
    @Autowired
    private FoodIngredientService foodIngredientService;

    @PostMapping("create")
    @Override
    public FoodIngredient create(@RequestBody FoodIngredient foodIngredient) {
        FoodIngredient foodIngredient1 = FoodIngredientFactory.getFoodIngredient(foodIngredient.getFoodId(),foodIngredient.getIngredientId(),foodIngredient.getDescription());
        return foodIngredientService.create(foodIngredient1);
    }

    @GetMapping("read")
    @Override
    public FoodIngredient read(@RequestParam("id") String id) {
        return foodIngredientService.read(id);
    }

    @PostMapping("update")
    @Override
    public FoodIngredient update(@RequestBody FoodIngredient foodIngredient) {
        return foodIngredientService.update(foodIngredient);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return foodIngredientService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<FoodIngredient> readALl() {
        return foodIngredientService.readAll();
    }
    /***
     * Return a list of Ingredients related to a particular
     * @param
     * @return
     */
    @GetMapping("readAllOf")
    @Override
    public List<FoodIngredient> readALlOff(@RequestParam("id") String id) {
        return foodIngredientService.readAllOf(id);
    }
    /***
     * Return a list of Ingredients related to a Food
     * @param
     * @return
     */
    @GetMapping("readAllFood")
    public List<FoodIngredient> readALlOffFood(@RequestParam("id") String id) {
        return foodIngredientService.readAllOfFood(id);
    }
}
