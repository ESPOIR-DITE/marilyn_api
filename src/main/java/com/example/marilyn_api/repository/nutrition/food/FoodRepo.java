package com.example.marilyn_api.repository.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,String> {
}
