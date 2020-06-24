package com.example.marilyn_api.Domain.workout;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WorkOut {
    @Id
    private String id;
    private String workoutTypeId;
    private String description;
    private Date date;

    private WorkOut() {
    }
    public WorkOut(Builder builder) {
        this.date = builder.date;
        this.description = builder.description;
        this.id = builder.id;
        this.workoutTypeId = builder.workoutTypeId;
    }

    public String getId() {
        return id;
    }

    public String getWorkoutTypeId() {
        return workoutTypeId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String workoutTypeId;
        private String description;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildWorkoutTypeId(String workoutTypeId){
            this.workoutTypeId = workoutTypeId;
            return this;
        }
        public Builder builDescription(String description){
            this.workoutTypeId = description;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public WorkOut build(){
            return new WorkOut(this);
        }
    }
}
