package com.example.marilyn_api.Domain.galery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gallery {
    @Id
    private String id;
    private String galery;
    private String description;

    private Gallery() {
    }
    public Gallery(Builder builder) {
        this.description = builder.description;
        this.galery = builder.galery;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public String getGalery() {
        return galery;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String galery;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildGalery(String galery){
            this.galery = galery;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Gallery build(){
            return new Gallery(this);
        }
    }
}
