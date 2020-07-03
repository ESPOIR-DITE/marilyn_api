package com.example.marilyn_api.service.user;

import com.example.marilyn_api.Domain.user.UserGender;
import com.example.marilyn_api.repository.user.UserGenderRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserGenderService implements Iservice<UserGender,String> {
    @Autowired
    private UserGenderRep userGenderRep;
    private static UserGenderService userGenderService;

    public static UserGenderService getUserGenderService() {
        if (userGenderService == null) {
            userGenderService = new UserGenderService();
        }
        return userGenderService;
    }

    @Override
    public UserGender create(UserGender userGender) {
        return userGenderRep.save(userGender);
    }

    @Override
    public UserGender update(UserGender userGender) {
        UserGender userGender1 = get(userGender.getId());
        if (userGender1 != null) {
            delete(userGender1.getId());
            return create(userGender);
        }
        return null;
    }

    @Override
    public UserGender read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        UserGender userGender1 = get(id);
        if (userGender1 != null) {
            delete(userGender1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<UserGender> readAll() {
        return userGenderRep.findAll();
    }

    @Override
    public UserGender get(String id) {
        Optional<UserGender> userGenderOptional = userGenderRep.findById(id);
        return userGenderOptional.orElse(null);
    }

    /****
     * here we are returning all the UserGender of a selected gender.
     * @param id
     * @return
     */

    @Override
    public List<UserGender> readAllOf(String id) {
        List<UserGender> userGenderList = new ArrayList<>();
        for(UserGender userGender: readAll()){
            if(userGender.getGenderId().equals(id)){
                userGenderList.add(userGender);
            }
        }
        return userGenderList;
    }
    /****
     * Read with email address
     */
    public UserGender readWIthEmail(String id) {
        for(UserGender userGender: readAll()){
            if(userGender.getEmail().equals(id)){
                return userGender;
            }
        }
        return null;
    }
}
