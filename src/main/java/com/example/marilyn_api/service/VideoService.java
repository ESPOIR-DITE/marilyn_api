package com.example.marilyn_api.service;

import com.example.marilyn_api.Domain.image.Videos;
import com.example.marilyn_api.repository.VideoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService implements Iservice<Videos,String>{
    private static VideoService videoService;
    @Autowired
    private VideoRep videoRep;
    @Override
    public Videos create(Videos videos) {
        return videoRep.save(videos);
    }

    @Override
    public Videos update(Videos videos) {
        Videos videos1 = get(videos.getId());
        if (videos1 != null) {
            videoRep.delete(videos1);
            return create(videos);
        }
        return null;
    }

    @Override
    public Videos read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Videos videos1 = get(id);
        if (videos1 != null) {
            videoRep.delete(videos1);
            return true;
        }
        return false;
    }

    @Override
    public List<Videos> readAll() {
        return videoRep.findAll();
    }

    @Override
    public Videos get(String id) {
        Optional<Videos>videosOptional = videoRep.findById(id);
        return videosOptional.orElse(null);
    }

    @Override
    public List<Videos> readAllOf(String id) {
        return null;
    }
}
