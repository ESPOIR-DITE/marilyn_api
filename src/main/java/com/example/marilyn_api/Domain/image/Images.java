package com.example.marilyn_api.Domain.image;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class Images {
    @Id
    private String id;
    private byte[] image;
    private String description;

    private Images() {
    }
    public Images(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.image = builder.image;
    }

    public String getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id='" + id + '\'' +
                ", image=" + Arrays.toString(image) +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String id;
        private byte[] image;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildVideo(byte[] video){
            this.image = video;
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
