package com.example.marilyn_api.Domain.nutrition.food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FoodIngredient {
    @Id
    private String id;
    private String foodId;
    private String ingredientId;
    private String description;

    private FoodIngredient() {
    }
    public FoodIngredient(Builder builder) {
        this.description = builder.description;
        this.foodId = builder.foodId;
        this.ingredientId = builder.ingredientId;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String foodId;
        private String ingredientId;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildFoodId(String foodId){
            this.foodId = foodId;
            return this;
        }
        public Builder buildIngredientId(String ingredientId){
            this.ingredientId = ingredientId;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public FoodIngredient build(){
            return new FoodIngredient(this);
        }
    }
}
