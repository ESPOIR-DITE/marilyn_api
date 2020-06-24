package com.example.marilyn_api.factory;

import com.example.marilyn_api.Domain.Videos;
import com.example.marilyn_api.util.GeneratId;

public class VideoFactory {
    public static Videos getVideos(String description,byte[] video){
        return new Videos.Builder(GeneratId.getId(VideoFactory.class))
                .buildDescription(description)
                .builderVideo(video)
                .build();
    }
}
