package com.example.marilyn_api.Domain.nutrition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NutritionVideo {
    @Id
    private String id;
    private String videoId;
    private String nutritionId;
    private String descrition;

    private NutritionVideo() {
    }
    public NutritionVideo(Builder builder) {
        this.descrition = builder.descrition;
        this.id = builder.id;
        this.nutritionId =builder.nutritionId;
        this.videoId = builder.videoId;
    }

    public String getId() {
        return id;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getNutritionId() {
        return nutritionId;
    }

    public String getDescrition() {
        return descrition;
    }
    public static class Builder{
        private String id;
        private String videoId;
        private String nutritionId;
        private String descrition;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildVideoId(String videoId){
            this.videoId = videoId;
            return this;
        }
        public Builder buildNutritionId(String nutritionId){
            this.nutritionId = nutritionId;
            return this;
        }
        public Builder buildDescription(String descrition){
            this.descrition = descrition;
            return this;
        }
        public NutritionVideo build(){
            return new NutritionVideo(this);
        }
    }
}
