package com.example.marilyn_api.Domain.workout.exercise;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Step {
    @Id
    private String id;
    private String name;
    private String duration;
    private String times;
    private String description;

    private Step() {
    }

    public Step(Builder builder) {
        this.id = builder.id;
        this.times = builder.times;
        this.name = builder.name;
        this.description = builder.description;
        this.duration = builder.duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public String getTimes() {
        return times;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String name;
        private String duration;
        private String times;
        private String description;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildDuration(String duration){
            this.duration = duration;
            return this;
        }
        public Builder buildTime(String times){
            this.times = times;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy(Step step){
            this.id = step.id;
            this.times = step.times;
            this.name = step.name;
            this.description = step.description;
            this.duration = step.duration;
            return this;
        }
        public Step build(){
            return new Step(this);
        }
    }
}
