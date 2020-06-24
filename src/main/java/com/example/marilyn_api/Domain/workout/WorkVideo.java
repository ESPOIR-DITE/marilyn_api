package com.example.marilyn_api.Domain.workout;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkVideo {
    @Id
    private String id;
    private String workOutId;
    private String description;

    private WorkVideo() {
    }
    public WorkVideo(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.workOutId = builder.workOutId;
    }

    public String getId() {
        return id;
    }

    public String getWorkOutId() {
        return workOutId;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String workOutId;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildWorkoutId(String workOutId){
            this.workOutId = workOutId;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public WorkVideo build(){
            return new WorkVideo(this);
        }
    }
}
