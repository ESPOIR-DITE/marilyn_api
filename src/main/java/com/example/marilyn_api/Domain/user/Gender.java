package com.example.marilyn_api.Domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gender {
    @Id
    private String id;
    private String gender;

    private Gender() {
    }
    public Gender(Builder builder) {
        this.gender = builder.gender;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }
    public static class Builder{
        private String id;
        private String gender;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildGender(String gender){
            this.gender = gender;
            return this;
        }
        public Gender build(){
            return new Gender(this);
        }

    }
}
