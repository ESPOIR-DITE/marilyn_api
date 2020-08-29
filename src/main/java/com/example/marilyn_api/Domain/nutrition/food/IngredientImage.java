package com.example.marilyn_api.Domain.nutrition.food;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientImage {
    @Id
    private String id;
    private String ingredientId;
    private String imageId;

    private IngredientImage() {
    }

    public IngredientImage(Builder builder) {
        this.id = builder.id;
        this.imageId = builder.imageId;
        this.ingredientId = builder.ingredientId;
    }

    public String getId() {
        return id;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public String getImageId() {
        return imageId;
    }
    public static class Builder{
        private String id;
        private String ingredientId;
        private String imageId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildIngredientId(String ingredientId){
            this.ingredientId = ingredientId;
            return this;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public IngredientImage build(){
            return new IngredientImage(this);
        }
    }
}
