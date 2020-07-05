package com.example.marilyn_api.controller.user;

import com.example.marilyn_api.Domain.user.UserGender;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.factory.user.UserGenderFactory;
import com.example.marilyn_api.service.user.UserGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/user_gender")
public class UserGenderController implements Icontroller<UserGender,String> {
    @Autowired
    private UserGenderService userGenderService;

    @PostMapping("create")
    @Override
    public UserGender create(@RequestBody UserGender userGender) {
        UserGender userGender1 = UserGenderFactory.getUserGender(userGender.getGenderId(),userGender.getEmail());
        return userGenderService.create(userGender1);
    }
    @GetMapping("read")
    @Override
    public UserGender read(@RequestParam("id") String id) {
        return userGenderService.read(id);
    }
    @PostMapping("update")
    @Override
    public UserGender update(@RequestBody UserGender userGender) {
        return userGenderService.update(userGender);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return userGenderService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<UserGender> readALl() {
        return userGenderService.readAll();
    }
    @GetMapping("readAllOff")
    @Override
    public List<UserGender> readALlOff(@RequestParam("id") String id) {
        return userGenderService.readAllOf(id);
    }
    @GetMapping("readWithEmail")
    public UserGender readWithEmailAddress(@RequestParam("id") String email){
        return userGenderService.readWIthEmail(email);
    }
}
