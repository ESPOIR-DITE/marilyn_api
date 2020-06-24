package com.example.marilyn_api.Domain.workout;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkOutImage {
    @Id
    private String id;
    private String workOutId;
    private String imageId;

    private WorkOutImage() {
    }
    public WorkOutImage(Builder builder) {
        this.id = builder.id;
        this.imageId = builder.imageId;
        this.workOutId = builder.workOutId;
    }

    public String getId() {
        return id;
    }

    public String getWorkOutId() {
        return workOutId;
    }

    public String getImageId() {
        return imageId;
    }
    public static class Builder{
        private String id;
        private String workOutId;
        private String imageId;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildWorkOut(String workOutId){
            this.workOutId = workOutId;
            return this;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public WorkOutImage build(){
            return new WorkOutImage(this);
        }
    }
}
