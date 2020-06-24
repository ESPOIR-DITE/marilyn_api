package com.example.marilyn_api.Domain.user.health;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Health {
    @Id
    private String id;
    private String health;
    private String description;

    private Health() {
    }
    public Health(Builder builder) {
        this.description = builder.description;
        this.health = builder.health;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public String getHealth() {
        return health;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String health;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildHealth(String health){
            this.health = health;
            return this;
        }
        public Builder builderDescription(String description){
            this.description = description;
        return this;
        }
        public Health build(){
            return new Health(this);
        }
    }
}
