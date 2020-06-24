package com.example.marilyn_api.Domain.nutrition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NutritionImage {
    @Id
    private String id;
    private String imageId;
    private String description;

    public NutritionImage() {
    }
    public NutritionImage(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.imageId = builder.imageId;
    }

    public String getId() {
        return id;
    }

    public String getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String imageId;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public NutritionImage build(){
            return new NutritionImage(this);
        }
    }
}
