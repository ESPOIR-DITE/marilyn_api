package com.example.marilyn_api.Domain.workout;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkExercise {
    @Id
    private String id;
    private String workOutId;
    private String exerciseId;
    private String description;

    private WorkExercise() {
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public WorkExercise(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.workOutId = builder.workOutId;
        this.exerciseId = builder.exerciseId;
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
        private String exerciseId;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildExerciseId(String exerciseId){
            this.exerciseId = exerciseId;
            return this;
        }
        public Builder buildWorkoutId(String workOutId){
            this.workOutId = workOutId;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy(WorkExercise workExercise){
            this.id = workExercise.id;
            this.description = workExercise.description;
            this.workOutId = workExercise.workOutId;
            this.exerciseId = workExercise.exerciseId;
            return this;
        }
        public WorkExercise build(){
            return new WorkExercise(this);
        }
    }
}
