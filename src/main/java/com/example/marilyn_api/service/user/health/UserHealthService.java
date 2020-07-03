package com.example.marilyn_api.service.user.health;

import com.example.marilyn_api.Domain.user.health.UserHealth;
import com.example.marilyn_api.repository.user.UsersRep;
import com.example.marilyn_api.repository.user.health.UserHealthRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserHealthService implements Iservice<UserHealth,String> {
    private static UserHealthService userHealthService;
    @Autowired
    private UserHealthRep userHealthRep;

    public static UserHealthService getUserHealthService() {
        if (userHealthService == null) {
            userHealthService = new UserHealthService();
        }
        return userHealthService;
    }

    @Override
    public UserHealth create(UserHealth userHealth) {
        return userHealthRep.save(userHealth);
    }

    @Override
    public UserHealth update(UserHealth userHealth) {
        UserHealth userHealth1 = get(userHealth.getId());
        if (userHealth1 != null) {
            delete(userHealth1.getId());
            return create(userHealth);
        }
        return null;
    }

    @Override
    public UserHealth read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        UserHealth userHealth1 = get(id);
        if (userHealth1 != null) {
            delete(userHealth1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<UserHealth> readAll() {
        return userHealthRep.findAll();
    }

    @Override
    public UserHealth get(String id) {
        Optional<UserHealth> userHealthOptional = userHealthRep.findById(id);
        return userHealthOptional.orElse(null);
    }

    /****
     * Reading all with user Id which is email.
     * @param id
     * @return
     */
    @Override
    public List<UserHealth> readAllOf(String id) {
        List<UserHealth> userHealthList = new ArrayList<>();
        for(UserHealth userHealth: readAll()){
            if(userHealth.getEmail().equals(id)){
                userHealthList.add(userHealth);
            }
        }
        return userHealthList;
    }
}
