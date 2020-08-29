package com.example.marilyn_api.controller.image;

import com.example.marilyn_api.Domain.image.Images;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.image.ImageFactory;
import com.example.marilyn_api.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("fcma/image/")
public class ImageController implements Icontroller<Images,String> {
    @Autowired
    private ImageService imageService;

    @PostMapping("create")
    @Override
    public Images create(@RequestBody Images images) throws IOException {
        return imageService.create(images);
    }

    @GetMapping("read")
    @Override
    public Images read(@RequestParam("id") String id) {
        return imageService.read(id);
    }

    @PostMapping("update")
    @Override
    public Images update(@RequestBody Images images) throws IOException {
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
    @GetMapping("readOf")

    @Override
    public List<Images> readALlOff(String id) {
        return null;
    }
}
