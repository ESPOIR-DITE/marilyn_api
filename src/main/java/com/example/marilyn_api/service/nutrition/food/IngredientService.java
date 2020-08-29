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
        return ingredientRepo.save(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        Ingredient ingredient1 = get(ingredient.getId());
        if (ingredient1 != null) {
            ingredientRepo.delete(ingredient);
            return create(ingredient);
        }
        return null;
    }

    @Override
    public Ingredient read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Ingredient ingredient = get(id);
        if (ingredient != null) {
             ingredientRepo.delete(ingredient);
            return true;
        }
        return false;
    }

    @Override
    public List<Ingredient> readAll() {
        return ingredientRepo.findAll();
    }

    @Override
    public Ingredient get(String id) {
        Optional<Ingredient> ingredientOptional = ingredientRepo.findById(id);
        return ingredientOptional.orElse(null);
    }

    /***
     * Return a list of Ingredients related to a particular
     * @param id
     * @return
     */
    @Override
    public List<Ingredient> readAllOf(String id) {
        return ingredientRepo.findAll();
    }
}
