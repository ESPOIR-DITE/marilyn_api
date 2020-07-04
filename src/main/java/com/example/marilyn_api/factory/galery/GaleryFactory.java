package com.example.marilyn_api.factory.galery;

import com.example.marilyn_api.Domain.galery.Gallery;
import com.example.marilyn_api.util.GeneratId;

public class GaleryFactory {
    public static Gallery getGallery(String gallery, String description){
        return new Gallery.Builder(GeneratId.getId(GaleryFactory.class))
                .buildDescription(description)
                .buildGalery(gallery)
                .build();
    }
    public static Gallery getGalleryCopy(Gallery gallery){
        return new Gallery.Builder(GeneratId.getId(GaleryFactory.class))
                .buildDescription(gallery.getDescription())
                .buildGalery(gallery.getGallery())
                .build();
    }
}
