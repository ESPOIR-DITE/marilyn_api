package com.example.marilyn_api.controller.user.gender;

import com.example.marilyn_api.Domain.user.Gender;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.GenderFactory;
import com.example.marilyn_api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/gender")
public class GenderController implements Icontroller<Gender,String> {
    @Autowired
    private GenderService genderService;

    @PostMapping("create")
    @Override
    public Gender create(@RequestBody Gender gender) {
        Gender gender1 = GenderFactory.getGender(gender.getGender());
        return genderService.create(gender1);
    }
    @GetMapping("read")
    @Override
    public Gender read(@RequestParam("id") String id) {
        return genderService.read(id);
    }
    @PostMapping("update")
    @Override
    public Gender update(@RequestBody Gender gender) {
        return genderService.update(gender);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return genderService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<Gender> readALl() {
        return genderService.readAll();
    }
    @Override
    public List<Gender> readALlOff(String id) {
        return genderService.readAllOf(id);
    }
}
