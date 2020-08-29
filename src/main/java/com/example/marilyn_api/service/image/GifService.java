package com.example.marilyn_api.service.image;

import com.example.marilyn_api.Domain.image.Gifs;
import com.example.marilyn_api.repository.image.GifRepository;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GifService implements Iservice<Gifs,String> {
    @Autowired
    private GifRepository gifRepository;
    private static GifService gifService;

    public static GifService getGifService() {
        if (gifService == null) {
            gifService = new GifService();
        }
        return gifService;
    }

    @Override
    public Gifs create(Gifs gifs) throws IOException {
        return gifRepository.save(gifs);
    }

    @Override
    public Gifs update(Gifs gifs) throws IOException {
        return gifRepository.save(gifs);
    }

    @Override
    public Gifs read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Gifs gifs = get(id);
        if (gifs != null) {
            gifRepository.delete(gifs);
            return true;
        }
        return false;
    }

    @Override
    public List<Gifs> readAll() {
        return gifRepository.findAll();
    }

    @Override
    public Gifs get(String id) {
        Optional<Gifs> gifsOptional = gifRepository.findById(id);
        return gifsOptional.orElse(null);
    }

    @Override
    public List<Gifs> readAllOf(String id) {
        return null;
    }
}
