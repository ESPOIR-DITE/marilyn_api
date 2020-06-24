package com.example.marilyn_api.Domain.nutrition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nutrition {
    @Id
    private String id;
    private String nutritionType;
    private String name;
    private String description;
    private double price;

    private Nutrition() {
    }
    public Nutrition(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.nutritionType = builder.nutritionType;
    }

    public String getId() {
        return id;
    }

    public String getNutritionType() {
        return nutritionType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    public static class Builder{
        private String id;
        private String nutritionType;
        private String name;
        private String description;
        private double price;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildNutritionType(String nutritionType){
            this.nutritionType = nutritionType;
            return this;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder builderPrice(double price){
            this.price = price;
            return this;
        }
        public Nutrition build(){
            return new Nutrition(this);
        }
    }
}
