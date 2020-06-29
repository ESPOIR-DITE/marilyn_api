package com.example.marilyn_api.service.user;

import com.example.marilyn_api.Domain.user.Users;
import com.example.marilyn_api.repository.user.UsersRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Iservice<Users,String> {
    @Autowired
    private UsersRep usersRep;
    private static UserService userService;

    public static UserService getUserService(){
        if (userService == null) {
            userService = new UserService();
        }return userService;
    }
    @Override
    public Users create(Users users) {
        return null;
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Users read(String id) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public List<Users> readAll() {
        return null;
    }

    @Override
    public Users get(String id) {
        return null;
    }

    @Override
    public List<Users> readAllOf(String id) {
        return null;
    }
}
