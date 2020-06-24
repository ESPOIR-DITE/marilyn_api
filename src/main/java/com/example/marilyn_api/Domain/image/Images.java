package com.example.marilyn_api.Domain.image;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Images {
    @Id
    private String id;
    private byte[] video;
    private String description;

    private Images() {
    }
    public Images(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.video = builder.video;
    }

    public String getId() {
        return id;
    }

    public byte[] getVideo() {
        return video;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private byte[] video;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildVideo(byte[] video){
            this.video = video;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Images build(){
            return new Images(this);
        }
    }
}
