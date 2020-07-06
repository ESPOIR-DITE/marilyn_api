package com.example.marilyn_api.controller.image;

import com.example.marilyn_api.Domain.image.Videos;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.VideoFactory;
import com.example.marilyn_api.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/video")
public class VideoController implements Icontroller<Videos,String> {
    @Autowired
    private VideoService videoService;

    @PostMapping("create")
    @Override
    public Videos create(@RequestBody Videos videos) {
        Videos videos1 = VideoFactory.getVideos(videos.getDescription(),videos.getVideo());
        return videoService.create(videos1);
    }
    @GetMapping("read")
    @Override
    public Videos read(@RequestParam("id") String id) {
        return videoService.read(id);
    }
    @PostMapping("update")
    @Override
    public Videos update(@RequestBody Videos videos) {
        return videoService.update(videos);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return videoService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<Videos> readALl() {
        return videoService.readAll();
    }
    @GetMapping("readAllOf")
    @Override
    public List<Videos> readALlOff(@RequestParam("id") String id) {
        return videoService.readAllOf(id);
    }
}
