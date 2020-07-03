package com.example.marilyn_api.Domain.user.health;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserHealth {
    @Id
    private String id;
    private String email;
    private String healthId;
    private String description;
    private Date date;

    private UserHealth() {
    }

    public UserHealth(Builder builder) {
        this.date = builder.date;
        this.description = builder.description;
        this.healthId = builder.healthId;
        this.id = builder.id;
        this.email = builder.email;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }

    public String getHealthId() {
        return healthId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String email;
        private String healthId;
        private String description;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }
        public Builder buildHealthId(String healthId){
            this.healthId = healthId;
            return this;
        }
        public Builder buildDescrition(String description){
            this.description  = description;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public UserHealth build(){
            return new UserHealth(this);
        }
    }

}
