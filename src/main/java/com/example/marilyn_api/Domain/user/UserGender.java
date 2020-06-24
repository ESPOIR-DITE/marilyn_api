package com.example.marilyn_api.Domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserGender {
    @Id
    private String id;
    private String genderId;
    private String email;

    private UserGender() {
    }
    public UserGender(Builder builder) {
        this.email = builder.email;
        this.genderId = builder.genderId;
        this.id = builder.id;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getGenderId() {
        return genderId;
    }
    public static class Builder{
        private String id;
        private String genderId;
        private String email;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildGenderId(String genderId){
            this.genderId = genderId;
            return this;
        }
        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }
        public UserGender build(){
            return new UserGender(this);
        }
    }
}
