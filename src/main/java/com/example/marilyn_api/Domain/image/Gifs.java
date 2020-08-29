package com.example.marilyn_api.Domain.image;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gifs {
    @Id
    private String id;
    private byte[] gif;
    private String description;

    public Gifs(Builder builder) {
        this.description = builder.description;
        this.gif = builder.gif;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public byte[] getGif() {
        return gif;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private byte[] gif;
        private String description;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildGif(byte[] gif){
            this.gif = gif;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Gifs build(){
            return new Gifs(this);
        }
    }
}
