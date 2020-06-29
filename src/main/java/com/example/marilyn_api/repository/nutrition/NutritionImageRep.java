package com.example.marilyn_api.repository.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionImageRep extends JpaRepository<NutritionImage,String> {
}
