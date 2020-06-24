package com.example.marilyn_api.factory.user;

import com.example.marilyn_api.Domain.user.UserGender;
import com.example.marilyn_api.util.GeneratId;

public class UserGenderFactory {
    public static UserGender getUserGender(String genderId,String email){
        return  new UserGender.Builder(GeneratId.getId(UserGenderFactory.class))
                .buildEmail(email)
                .buildGenderId(genderId)
                .build();
    }
}
