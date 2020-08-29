package com.example.marilyn_api.repository.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.IngredientImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientImageRepo extends JpaRepository<IngredientImage,String> {
}
