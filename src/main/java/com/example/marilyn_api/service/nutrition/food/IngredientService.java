package com.example.marilyn_api.service.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Ingredient;
import com.example.marilyn_api.repository.nutrition.food.IngredientRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService implements Iservice<Ingredient,String> {
    private static IngredientService ingredientService;
    @Autowired
    private IngredientRepo ingredientRepo;

    public static IngredientService getIngredientService() {
        if (ingredientService == null) {
            ingredientService = new IngredientService();
        }
        return ingredientService;
    }

    @Override
    public Ingredient create(Ingredient ingredient) {
        return null;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return null;
    }

    @Override
    public Ingredient read(String id) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public List<Ingredient> readAll() {
        return null;
    }

    @Override
    public Ingredient get(String id) {
        Optional<Ingredient> ingredientOptional =
        return null;
    }

    @Override
    public List<Ingredient> readAllOf(String id) {
        return null;
    }
}
