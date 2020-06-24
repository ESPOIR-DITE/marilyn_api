package com.example.marilyn_api.factory.user;

import com.example.marilyn_api.Domain.user.UserImage;
import com.example.marilyn_api.util.GeneratId;

import java.util.Date;

public class UserImageFactory {
    public static UserImage getUserImage(String imageId,Date date){
        return new UserImage.Builder(GeneratId.getId(UserImageFactory.class))
                .buildDate(date)
                .buildImageId(imageId)
                .build();
    }
}
