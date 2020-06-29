package com.example.marilyn_api.repository.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionVideoRep extends JpaRepository<NutritionVideo,String> {
}
