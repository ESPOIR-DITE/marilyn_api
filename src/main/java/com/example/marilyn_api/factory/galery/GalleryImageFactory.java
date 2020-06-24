package com.example.marilyn_api.factory.galery;

import com.example.marilyn_api.Domain.galery.GalleryImage;
import com.example.marilyn_api.util.GeneratId;

public class GalleryImageFactory {
    public static GalleryImage getGalleryImage(String imageId,String galeryId){
        return new GalleryImage.Builder(GeneratId.getId(GalleryImage.class))
                .buildGaleryId(galeryId).buildImageId(imageId).build();
    }
}
