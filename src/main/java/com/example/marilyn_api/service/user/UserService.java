package com.example.marilyn_api.service.user;

import com.example.marilyn_api.Domain.user.Users;
import com.example.marilyn_api.repository.user.UsersRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return usersRep.save(users);
    }

    @Override
    public Users update(Users users) {
        Users users1 = get(users.getEmail());
        if (users1 != null) {
            delete(users1.getEmail());
            return create(users);
        }
        return null;
    }

    @Override
    public Users read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Users users1 = get(id);
        if (users1 != null) {
            delete(users1.getEmail());
            return true;
        }
        return false;
    }

    @Override
    public List<Users> readAll() {
        return usersRep.findAll();
    }

    @Override
    public Users get(String id) {
        Optional<Users> usersOptional = usersRep.findById(id);
        return usersOptional.orElse(null);
    }

    @Override
    public List<Users> readAllOf(String id) {
        return null;
    }
}
