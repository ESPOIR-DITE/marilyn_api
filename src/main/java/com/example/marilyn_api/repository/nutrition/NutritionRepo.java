package com.example.marilyn_api.repository.nutrition;

import com.example.marilyn_api.Domain.nutrition.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepo extends JpaRepository<Nutrition,String> {
}
