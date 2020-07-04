package com.example.marilyn_api.controller.image;

import com.example.marilyn_api.Domain.image.Images;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.image.ImageFactory;
import com.example.marilyn_api.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("fcma/image/")
public class ImageController implements Icontroller<Images,String> {
    @Autowired
    private ImageService imageService;

    @PostMapping("create")
    @Override
    public Images create(@RequestBody Images images) {
        Images images1 = ImageFactory.getImages(images.getVideo(),images.getDescription());
        return imageService.create(images1);
    }

    @GetMapping("read")
    @Override
    public Images read(@RequestParam("id") String id) {
        return imageService.read(id);
    }

    @PostMapping("update")
    @Override
    public Images update(@RequestBody Images images) {
        return imageService.update(images);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return imageService.delete(id);
    }

    @GetMapping("readAll")
    @Override
    public List<Images> readALl() {
        return imageService.readAll();
    }

    @Override
    public List<Images> readALlOff(String id) {
        return null;
    }
}
