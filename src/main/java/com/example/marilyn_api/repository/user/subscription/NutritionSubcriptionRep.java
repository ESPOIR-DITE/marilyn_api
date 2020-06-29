package com.example.marilyn_api.repository.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionSubcriptionRep extends JpaRepository<NutritionSubscription,String> {
}
