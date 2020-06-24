package com.example.marilyn_api.Domain.galery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GalleryImage {
    @Id
    private String id;
    private String imageId;
    private String galeryId;

    private GalleryImage() {
    }
    public GalleryImage(Builder builder) {
        this.galeryId = builder.galeryId;
        this.id = builder.id;
        this.imageId = builder.imageId;
    }

    public String getId() {
        return id;
    }

    public String getImageId() {
        return imageId;
    }

    public String getGaleryId() {
        return galeryId;
    }
    public static class Builder{
        private String id;
        private String imageId;
        private String galeryId;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public Builder buildGaleryId(String galeryId){
            this.galeryId = galeryId;
            return this;
        }
        public GalleryImage build(){
            return new GalleryImage(this);
        }
    }
}
