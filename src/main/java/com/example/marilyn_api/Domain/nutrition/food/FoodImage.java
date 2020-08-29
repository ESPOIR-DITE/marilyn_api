package com.example.marilyn_api.Domain.nutrition.food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FoodImage {
    @Id
    private String id;
    private String foodId;
    private String imageId;

    private FoodImage() {
    }

    public FoodImage(Builder builder) {
        this.id = builder.id;
        this.imageId = builder.imageId;
        this.foodId = builder.foodId;
    }

    public String getId() {
        return id;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getImageId() {
        return imageId;
    }
    public static class Builder{
        private String id;
        private String foodId;
        private String imageId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildFoodId(String ingredientId){
            this.foodId = ingredientId;
            return this;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public FoodImage build(){
            return new FoodImage(this);
        }
    }
}
