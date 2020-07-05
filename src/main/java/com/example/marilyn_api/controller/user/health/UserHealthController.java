package com.example.marilyn_api.controller.user.health;

import com.example.marilyn_api.Domain.user.health.UserHealth;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.health.UserHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/health_user/")
public class UserHealthController implements Icontroller<UserHealth,String> {
    @Autowired
    private UserHealthService userHealthService;
    @PostMapping("create")
    @Override
    public UserHealth create(UserHealth userHealth) {
        return userHealthService.create(userHealth);
    }
    @GetMapping("read")
    @Override
    public UserHealth read(@RequestParam("id") String id) {
        return userHealthService.read(id);
    }
    @PostMapping("update")
    @Override
    public UserHealth update(UserHealth userHealth) {
        return userHealthService.update(userHealth);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return userHealthService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<UserHealth> readALl() {
        return userHealthService.readAll();
    }
    @GetMapping("readAllOf")
    @Override
    public List<UserHealth> readALlOff(String id) {
        return userHealthService.readAllOf(id);
    }
}
