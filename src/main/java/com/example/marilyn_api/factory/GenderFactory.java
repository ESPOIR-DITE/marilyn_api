package com.example.marilyn_api.factory;

import com.example.marilyn_api.Domain.user.Gender;
import com.example.marilyn_api.util.GeneratId;

public class GenderFactory {
    public static Gender getGender(String gender){
        return new Gender.Builder(GeneratId.getId(GenderFactory.class))
                .buildGender(gender)
                .build();
    }
}
