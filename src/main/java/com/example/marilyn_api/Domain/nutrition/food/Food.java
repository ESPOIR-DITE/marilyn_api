package com.example.marilyn_api.Domain.nutrition.food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {
    @Id
    private String Id;
    private String foodName;
    private String description;

    private Food() {
    }
    public Food(Builder builder) {
        this.description = builder.description;
        this.foodName = builder.foodName;
        this.Id = builder.Id;
    }

    public String getId() {
        return Id;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String Id;
        private String foodName;
        private String description;
        public Builder(String id){
            this.Id = id;
        }
        public Builder buildFoodName(String foodName){
            this.foodName = foodName;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Food build(){
            return  new Food(this);
        }
    }
}
