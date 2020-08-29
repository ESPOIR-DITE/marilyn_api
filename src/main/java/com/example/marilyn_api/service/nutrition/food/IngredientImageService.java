package com.example.marilyn_api.service.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.IngredientImage;
import com.example.marilyn_api.repository.nutrition.food.IngredientImageRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientImageService implements Iservice<IngredientImage,String> {
    @Autowired
    private IngredientImageRepo ingredientImageRepo;

    private static IngredientService ingredientService;

    public static IngredientService getIngredientService() {
        if (ingredientService == null) {
            ingredientService = new IngredientService();
        }
        return ingredientService;
    }

    @Override
    public IngredientImage create(IngredientImage ingredientImage) {
        return ingredientImageRepo.save(ingredientImage);
    }

    @Override
    public IngredientImage update(IngredientImage ingredientImage) {
        return ingredientImageRepo.save(ingredientImage);
    }

    @Override
    public IngredientImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        IngredientImage ingredientImage = get(id);
        if (ingredientImage != null) {
            ingredientImageRepo.delete(ingredientImage);
            return true;
        }
        return false;
    }

    @Override
    public List<IngredientImage> readAll() {
        return ingredientImageRepo.findAll();
    }

    @Override
    public IngredientImage get(String id) {
        Optional<IngredientImage> ingredientImageOptional = ingredientImageRepo.findById(id);
        return ingredientImageOptional.orElse(null);
    }

    @Override
    public List<IngredientImage> readAllOf(String id) {
        List<IngredientImage> ingredientImageList = new ArrayList<>();
        for(IngredientImage ingredientImage: readAll()){
            if(ingredientImage.getIngredientId().equals(id)){
                ingredientImageList.add(ingredientImage);
            }
        }
        return ingredientImageList;
    }

    public IngredientImage readOf(String id) {
        for(IngredientImage ingredientImage: readAll()){
            if(ingredientImage.getIngredientId().equals(id)){
                return ingredientImage;
            }
        }
        return null;
    }
}
