package com.example.marilyn_api.controller.image;

import com.example.marilyn_api.Domain.image.Gifs;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.repository.image.GifRepository;
import com.example.marilyn_api.service.image.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("fcma/gifs/")
public class GifController implements Icontroller<Gifs,String> {
    @Autowired
    private GifService gifService;

    @PostMapping("create")
    @Override
    public Gifs create(@RequestBody Gifs gifs) throws IOException {
        return gifService.create(gifs);
    }

    @GetMapping("read")
    @Override
    public Gifs read(@RequestParam("id") String id) {
        return gifService.read(id);
    }

    @PostMapping("update")
    @Override
    public Gifs update(@RequestBody Gifs gifs) throws IOException {
        return gifService.update(gifs);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return gifService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Gifs> readALl() {
        return gifService.readAll();
    }

    @Override
    public List<Gifs> readALlOff(String id) {
        return null;
    }
}
