package com.example.marilyn_api.Domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    private String email;
    private String name;
    private String surName;
    private String dateOfBirth;
}
