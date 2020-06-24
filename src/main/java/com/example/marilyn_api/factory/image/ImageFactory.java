package com.example.marilyn_api.factory.image;

import com.example.marilyn_api.Domain.image.Images;
import com.example.marilyn_api.util.GeneratId;

public class ImageFactory {
    public static Images getImages(byte[] video,String description){
        return new Images.Builder(GeneratId.getId(ImageFactory.class))
                .buildDescription(description)
                .buildVideo(video)
                .build();
    }
}
