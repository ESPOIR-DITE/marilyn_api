package com.example.marilyn_api.repository.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodImageRepository extends JpaRepository<FoodImage,String> {
}
