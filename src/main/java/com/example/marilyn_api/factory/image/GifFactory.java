package com.example.marilyn_api.factory.image;

import com.example.marilyn_api.Domain.image.Gifs;
import com.example.marilyn_api.util.GeneratId;

public class GifFactory {
    public static Gifs getGifs(byte[] gif,String description){
        return new Gifs.Builder(GeneratId.getId(GifFactory.class))
                .buildDescription(description)
                .buildGif(gif)
                .build();
    }
}
