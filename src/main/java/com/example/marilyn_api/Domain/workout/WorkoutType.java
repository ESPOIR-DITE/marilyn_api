package com.example.marilyn_api.Domain.workout;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WorkoutType {
    @Id
    private String id;
    private String workOutType;
    private Date date;
    private String description;


    private WorkoutType() {
    }

    public String getDescription() {
        return description;
    }

    public WorkoutType(Builder builder) {
        this.date = builder.date;
        this.id = builder.id;
        this.workOutType = builder.workOutType;
        this.description = builder.description;
    }

    public String getId() {
        return id;
    }

    public String getWorkOutType() {
        return workOutType;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String workOutType;
        private Date date;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildWorkOutType(String workOutType){
            this.workOutType = workOutType;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public WorkoutType build(){
            return new WorkoutType(this);
        }
    }
}
