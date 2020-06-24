package com.example.marilyn_api.factory.user.health;

import com.example.marilyn_api.Domain.user.health.UserHealth;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class UserHealthFactory {
    public static UserHealth getUserHealth(String healthId,String description,Date date){
        return new UserHealth.Builder(GeneratId.getId(UserHealthFactory.class))
                .buildDate(date)
                .buildDescrition(description)
                .buildHealthId(healthId)
                .build();
    }
}
