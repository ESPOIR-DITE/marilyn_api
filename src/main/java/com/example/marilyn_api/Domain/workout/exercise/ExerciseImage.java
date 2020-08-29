package com.example.marilyn_api.Domain.workout.exercise;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExerciseImage {
    @Id
    private String id;
    private String exerciseId;
    private String imageId;
    private String description;

    private ExerciseImage() {
    }

    public ExerciseImage(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.imageId = builder.imageId;
        this.exerciseId = builder.exerciseId;
    }

    public String getId() {
        return id;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getImageId() {
        return imageId;
    }


    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String exerciseId;
        private String imageId;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildExerciseId(String exerciseId){
            this.exerciseId = exerciseId;
            return this;
        }
        public Builder ImageId(String imageId){
            this.imageId = imageId;
            return this;
        }

        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy(ExerciseImage exerciseStepImage){
            this.id = exerciseStepImage.id;
            this.description = exerciseStepImage.description;
            this.imageId = exerciseStepImage.imageId;
            this.exerciseId = exerciseStepImage.exerciseId;
            return this;
        }
        public ExerciseImage build(){
            return new ExerciseImage(this);
        }
    }
}
