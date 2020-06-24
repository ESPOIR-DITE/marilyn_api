package com.example.marilyn_api.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Videos {
    @Id
    private String id;
    private String description;
    private byte[] video;

    private Videos() {
    }
    public Videos(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.video = builder.video;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getVideo() {
        return video;
    }
    public static class Builder{
        private String id;
        private String description;
        private byte[] video;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder builderVideo(byte[] video){
            this.video = video;
            return this;
        }
        public Videos build(){
            return new Videos(this);
        }
    }
}
