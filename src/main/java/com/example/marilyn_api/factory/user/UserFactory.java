package com.example.marilyn_api.factory.user;

import com.example.marilyn_api.Domain.user.Users;

import java.util.Date;

public class UserFactory {
    public static Users getUserFactory(String email,String name,String surname,Date dateOfBirth){
        return new Users.Builder(email)
                .buildDateOfBirth(dateOfBirth)
                .buildName(name)
                .buildSurname(surname)
                .build();
    }
}
