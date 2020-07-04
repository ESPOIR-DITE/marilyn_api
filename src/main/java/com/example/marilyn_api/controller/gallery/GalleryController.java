package com.example.marilyn_api.controller.gallery;

import com.example.marilyn_api.Domain.galery.Gallery;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.galery.GaleryFactory;
import com.example.marilyn_api.service.galery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/gallery/")
public class GalleryController implements Icontroller<Gallery,String> {

    @Autowired
    private GalleryService galleryService;

    @PostMapping("create")
    @Override
    public Gallery create(@RequestBody Gallery gallery) {
        Gallery gallery1 = GaleryFactory.getGalleryCopy(gallery);
        return galleryService.create(gallery1);
    }

    @GetMapping("read")
    @Override
    public Gallery read(@RequestParam("id") String id) {
        return galleryService.read(id);
    }

    @PostMapping("update")
    @Override
    public Gallery update(@RequestBody Gallery gallery) {
        return galleryService.update(gallery);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return galleryService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<Gallery> readALl() {
        return galleryService.readAll();
    }

    @Override
    public List<Gallery> readALlOff(String id) {
        return null;
    }
}
