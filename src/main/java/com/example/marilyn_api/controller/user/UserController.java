package com.example.marilyn_api.controller.user;

import com.example.marilyn_api.Domain.user.Users;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/user/")
public class UserController implements Icontroller<Users,String> {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    @Override
    public Users create(@RequestBody Users users) {
        return userService.create(users);
    }
    @GetMapping("read")
    @Override
    public Users read(@RequestParam("id") String id) {
        return userService.read(id);
    }
    @PostMapping("update")
    @Override
    public Users update(@RequestBody Users users) {
        return userService.update(users);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return userService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<Users> readALl() {
        return userService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<Users> readALlOff(@RequestParam("id") String id) {
        return userService.readAllOf(id);
    }
}
