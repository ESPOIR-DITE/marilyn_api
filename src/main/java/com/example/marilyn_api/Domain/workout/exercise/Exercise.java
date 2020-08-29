package com.example.marilyn_api.Domain.workout.exercise;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercise {
    @Id
    private String id;
    private String name;
    private int duration;
    private String description;

    private Exercise() {
    }

    public Exercise(Builder builder) {
        this.description = builder.description;
        this.duration = builder.duration;
        this.name = builder.name;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String name;
        private int duration;
        private String description;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildDuration(int duration){
            this.duration = duration;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy(Exercise exercise){
            this.description = exercise.description;
            this.duration = exercise.duration;
            this.name = exercise.name;
            this.id = exercise.id;
            return this;
        }
        public Exercise build(){
            return new Exercise(this);
        }
    }

}
