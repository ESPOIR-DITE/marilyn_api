package com.example.marilyn_api.factory.user.health;

import com.example.marilyn_api.Domain.user.health.Health;
import com.example.marilyn_api.util.GeneratId;

public class HealthFactory {
    public static Health getHealth(String health,String description){
        return new Health.Builder(GeneratId.getId(HealthFactory.class))
                .builderDescription(description)
                .buildHealth(health)
                .build();
    }
}
