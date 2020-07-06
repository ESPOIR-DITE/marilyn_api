package com.example.marilyn_api.Domain.nutrition.food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    private String id;
    private String name;
    private  String description;

    private Ingredient() {
    }
    public Ingredient(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.name = builder.ingredient;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public static class  Builder{
        private String id;
        private String ingredient;
        private  String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildIngredient(String ingredient){
            this.ingredient = ingredient;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Ingredient build(){
            return new Ingredient(this);
        }
    }
}
