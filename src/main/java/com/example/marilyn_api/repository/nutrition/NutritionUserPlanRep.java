package com.example.marilyn_api.repository.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionUserPlanRep extends JpaRepository<NutritionType,String> {
}
