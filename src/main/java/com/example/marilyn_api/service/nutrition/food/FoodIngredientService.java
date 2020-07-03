package com.example.marilyn_api.service.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodIngredient;
import com.example.marilyn_api.repository.nutrition.food.FoodIngredientRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodIngredientService implements Iservice<FoodIngredient,String> {
    private static FoodIngredientService foodIngredientService;
    @Autowired
    private FoodIngredientRepo foodIngredientRepo;

    public static FoodIngredientService getFoodIngredientService() {
        if (foodIngredientService == null) {
            foodIngredientService = new FoodIngredientService();
        }
        return foodIngredientService;
    }

    @Override
    public FoodIngredient create(FoodIngredient foodIngredient) {
        return foodIngredientRepo.save(foodIngredient);
    }

    @Override
    public FoodIngredient update(FoodIngredient foodIngredient) {
        FoodIngredient foodIngredient1 = get(foodIngredient.getId());
        if (foodIngredient1 != null) {
            foodIngredientRepo.delete(foodIngredient1);
            return create(foodIngredient);
        }
        return null;
    }

    @Override
    public FoodIngredient read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        FoodIngredient foodIngredient1 = get(id);
        if (foodIngredient1 != null) {
            foodIngredientRepo.delete(foodIngredient1);
            return true;
        }
        return false;
    }

    @Override
    public List<FoodIngredient> readAll() {
        return foodIngredientRepo.findAll();
    }

    @Override
    public FoodIngredient get(String id) {
        Optional<FoodIngredient> foodIngredientOptional = foodIngredientRepo.findById(id);
        return foodIngredientOptional.orElse(null);
    }

    /***
     * Return a list of Ingredients related to a particular
     * @param ingredientId
     * @return
     */
    @Override
    public List<FoodIngredient> readAllOf(String ingredientId) {
        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        for(FoodIngredient foodIngredient: readAll()){
            if(foodIngredient.getIngredientId().equals(ingredientId)){
                foodIngredientList.add(foodIngredient);
            }
        }
        return foodIngredientList;
    }
    /***
     * Return a list of Ingredients related to a Food
     * @param foodId
     * @return
     */
    public List<FoodIngredient> readAllOfFood(String foodId) {
        List<FoodIngredient> foodIngredientList = new ArrayList<>();
        for(FoodIngredient foodIngredient: readAll()){
            if(foodIngredient.getIngredientId().equals(foodId)){
                foodIngredientList.add(foodIngredient);
            }
        }
        return foodIngredientList;
    }
}
