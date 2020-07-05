package com.example.marilyn_api.controller.user;

import com.example.marilyn_api.Domain.user.UserImage;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/user_image")
public class UserImageController implements Icontroller<UserImage,String> {
    @Autowired
    private UserImageService userImageService;

    @PostMapping("create")
    @Override
    public UserImage create(@RequestBody UserImage userImage) {
        return userImageService.create(userImage);
    }
    @GetMapping("read")
    @Override
    public UserImage read(@RequestParam("id") String id) {
        return userImageService.read(id);
    }
    @PostMapping("update")
    @Override
    public UserImage update(@RequestBody UserImage userImage) {
        return userImageService.update(userImage);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return userImageService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<UserImage> readALl() {
        return userImageService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<UserImage> readALlOff(@RequestParam("id") String id) {
        return userImageService.readAllOf(id);
    }
}
