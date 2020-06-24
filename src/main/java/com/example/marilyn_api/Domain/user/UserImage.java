package com.example.marilyn_api.Domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class UserImage {
    @Id
    private String id;
    private String imageId;
    private Date date;

    private UserImage() {
    }
    public UserImage(Builder builder) {
        this.date = builder.date;
        this.id = builder.id;
        this.imageId = builder.imageId;
    }

    public String getId() {
        return id;
    }

    public String getImageId() {
        return imageId;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String imageId;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public UserImage build(){
            return new UserImage(this);
        }
    }
}
