package com.example.marilyn_api.service.image;

import com.example.marilyn_api.Domain.image.Images;
import com.example.marilyn_api.repository.image.ImageRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements Iservice<Images,String> {
    private static ImageService imageService;
    @Autowired
    private ImageRepo imageRepo;

    public static ImageService getImageService() {
        if (imageService == null) {
            imageService = new ImageService();
        }
        return imageService;
    }

    @Override
    public Images create(Images images) {
        return imageRepo.save(images);
    }

    @Override
    public Images update(Images images) {
        Images images1 = get(images.getId());
        if (images1 != null) {
            delete(images1.getId());
            return create(images);
        }
        return null;
    }

    @Override
    public Images read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Images images1 = get(id);
        if (images1 != null) {
            delete(images1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Images> readAll() {
        return imageRepo.findAll();
    }

    @Override
    public Images get(String id) {
       Optional<Images>imagesOptional= imageRepo.findById(id);
        return imagesOptional.orElse(null);
    }

    @Override
    public List<Images> readAllOf(String id) {
        return null;
    }
}
