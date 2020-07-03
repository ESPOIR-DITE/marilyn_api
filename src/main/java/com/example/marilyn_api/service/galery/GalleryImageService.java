package com.example.marilyn_api.service.galery;

import com.example.marilyn_api.Domain.galery.Gallery;
import com.example.marilyn_api.Domain.galery.GalleryImage;
import com.example.marilyn_api.repository.gallery.GalleryImageRepo;
import com.example.marilyn_api.repository.gallery.GalleryRepo;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryImageService implements Iservice<GalleryImage,String> {
    @Autowired
    private GalleryImageRepo galleryImageRepo;
    private static GalleryImageService galleryImageService;

    public static GalleryImageService getGalleryImageService() {
        if (galleryImageService == null) {
            galleryImageService= new GalleryImageService();
        }
        return galleryImageService;
    }

    @Override
    public GalleryImage create(GalleryImage galleryImage) {
        return galleryImageRepo.save(galleryImage);
    }

    @Override
    public GalleryImage update(GalleryImage galleryImage) {
        GalleryImage galleryImage1 = get(galleryImage.getId());
        if (galleryImage1 != null) {
            delete(galleryImage1.getId());
            return create(galleryImage);
        }
        return null;
    }

    @Override
    public GalleryImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        GalleryImage galleryImage1 = get(id);
        if (galleryImage1 != null) {
            delete(galleryImage1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<GalleryImage> readAll() {
        return galleryImageRepo.findAll();
    }

    @Override
    public GalleryImage get(String id) {
        Optional<GalleryImage> galleryImageOptional = galleryImageRepo.findById(id);
        return galleryImageOptional.orElse(null);
    }

    /****
     * this method will return all the gallery objects based on imageDI
     */
    public GalleryImage getAll(String id){
        for(GalleryImage galleryImage: readAll()){
            if(galleryImage.getImageId().equals(id)){
                return galleryImage;
            }
        }return null;
    }
    @Override
    public List<GalleryImage> readAllOf(String id) {
        return null;
    }
}
