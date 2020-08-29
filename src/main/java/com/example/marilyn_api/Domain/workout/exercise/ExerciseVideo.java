package com.example.marilyn_api.Domain.workout.exercise;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExerciseVideo {
    @Id
    private String id;
    private String videoId;
    private String exerciseId;
    private String description;

    private ExerciseVideo() {
    }

    public ExerciseVideo(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.videoId = builder.videoId;
        this.exerciseId = builder.exerciseId;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getId() {
        return id;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String videoId;
        private String exerciseId;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildVideoId(String videoId){
            this.videoId = videoId;
            return this;
        }
        public Builder buildExercise(String exerciseId){
            this.exerciseId = exerciseId;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy(ExerciseVideo exerciseVideo){
            this.id = exerciseVideo.id;
            this.description = exerciseVideo.description;
            this.videoId = exerciseVideo.videoId;
            this.exerciseId = exerciseVideo.exerciseId;
            return this;
        }
        public ExerciseVideo build(){
            return new ExerciseVideo(this);
        }
    }
}
