package com.example.marilyn_api.service.galery;

import com.example.marilyn_api.Domain.galery.Gallery;
import com.example.marilyn_api.repository.gallery.GalleryRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService implements Iservice<Gallery,String> {
    @Autowired
    private GalleryRepo galleryRepo;
    private static GalleryService galleryService;

    public static GalleryService getGalleryService() {
        if (galleryService == null) {
            galleryService = new GalleryService();
        }
        return galleryService;
    }

    @Override
    public Gallery create(Gallery gallery) {
        return null;
    }

    @Override
    public Gallery update(Gallery gallery) {
        Gallery gallery1 = get(gallery.getId());
        if (gallery1 != null) {
            delete(gallery1.getId());
            return create(gallery);
        }
        return null;
    }

    @Override
    public Gallery read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Gallery gallery1 = get(id);
        if (gallery1 != null) {
            delete(gallery1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Gallery> readAll() {
        return galleryRepo.findAll();
    }

    @Override
    public Gallery get(String id) {
        Optional<Gallery> galleryOptional = galleryRepo.findById(id);
        return galleryOptional.orElse(null);
    }

    @Override
    public List<Gallery> readAllOf(String id) {
        return null;
    }
}
