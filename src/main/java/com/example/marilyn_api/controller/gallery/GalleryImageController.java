package com.example.marilyn_api.controller.gallery;

import com.example.marilyn_api.Domain.galery.GalleryImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.galery.GalleryImageFactory;
import com.example.marilyn_api.service.galery.GalleryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/gallery_image/")
public class GalleryImageController implements Icontroller<GalleryImage,String> {
    @Autowired
    private GalleryImageService galleryImageService;

    @PostMapping("create")
    @Override
    public GalleryImage create(@RequestBody GalleryImage galleryImage) {
        GalleryImage galleryImage1 = GalleryImageFactory.getGalleryImage(galleryImage.getImageId(),galleryImage.getGaleryId());
        return galleryImageService.create(galleryImage1);
    }

    @GetMapping("read")
    @Override
    public GalleryImage read(@RequestParam("id") String id) {
        return galleryImageService.read(id);
    }

    @PostMapping("update")
    @Override
    public GalleryImage update(@RequestBody GalleryImage galleryImage) {
        return galleryImageService.update(galleryImage);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return galleryImageService.delete(id);
    }

    @GetMapping("realAll")
    @Override
    public List<GalleryImage> readALl() {
        return galleryImageService.readAll();
    }

    @GetMapping("readAllOf")
    @Override
    public List<GalleryImage> readALlOff(String id) {
        return galleryImageService.readAllOf(id);
    }
}
