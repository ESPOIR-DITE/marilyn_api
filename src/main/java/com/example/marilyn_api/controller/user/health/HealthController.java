package com.example.marilyn_api.controller.user.health;

import com.example.marilyn_api.Domain.user.health.Health;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.health.HealthService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/health/")
public class HealthController implements Icontroller<Health,String> {
    @Autowired
    private HealthService healthService;

    @PostMapping("create")
    @Override
    public Health create(@RequestBody Health health) {
        return healthService.create(health);
    }
    @GetMapping("read")
    @Override
    public Health read(@RequestParam("id") String id) {
        return healthService.read(id);
    }
    @PostMapping("update")
    @Override
    public Health update(@RequestBody Health health) {
        return healthService.update(health);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return healthService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<Health> readALl() {
        return healthService.readAll();
    }
    @Override
    public List<Health> readALlOff(String id) {
        return null;
    }
}
