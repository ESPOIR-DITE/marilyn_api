package com.example.marilyn_api.factory.galery;

import com.example.marilyn_api.Domain.galery.Galery;
import com.example.marilyn_api.util.GeneratId;

public class GaleryFactory {
    public static Galery getGalery(String galery,String description){
        return new Galery.Builder(GeneratId.getId(GaleryFactory.class))
                .buildDescription(description)
                .buildGalery(galery)
                .build();
    }
}
