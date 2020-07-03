package com.example.marilyn_api.service.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Food;
import com.example.marilyn_api.repository.nutrition.food.FoodRepo;
import com.example.marilyn_api.service.Iservice;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements Iservice<Food,String> {
    private static FoodService foodService;
    @Autowired
    private FoodRepo foodRepo;

    public static FoodService getFoodService() {
        if (foodService == null) {
            foodService = new FoodService();
        }
        return foodService;
    }

    @Override
    public Food create(Food food) {
        return foodRepo.save(food);
    }

    @Override
    public Food update(Food food) {
        Food food1 = get(food.getId());
        if (food1 != null) {
            delete(food1.getId());
            return create(food1);
        }
        return null;
    }

    @Override
    public Food read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Food food1 = get(id);
        if (food1 != null) {
            foodRepo.delete(food1);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> readAll() {
        return foodRepo.findAll();
    }

    @Override
    public Food get(String id) {
        Optional<Food> foodOptional =foodRepo.findById(id);
        return foodOptional.orElse(null);
    }

    @Override
    public List<Food> readAllOf(String id) {
        return null;
    }
}
