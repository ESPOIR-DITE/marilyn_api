package com.example.marilyn_api.service.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodIngredient;
import com.example.marilyn_api.repository.nutrition.food.FoodIngredientRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public FoodIngredient read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        return null;
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

    @Override
    public List<FoodIngredient> readAllOf(String id) {
        return null;
    }
}
