package com.example.marilyn_api.service;

import com.example.marilyn_api.Domain.user.Gender;
import com.example.marilyn_api.repository.GenderRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService implements Iservice<Gender,String>{
    private static GenderService genderService;
    @Autowired
    private GenderRep genderRep;

    public static GenderService getGenderService() {
        if (genderService == null) {
            genderService = new GenderService();
        }
        return genderService;
    }

    @Override
    public Gender create(Gender gender) {
        return genderRep.save(gender);
    }

    @Override
    public Gender update(Gender gender1) {
        Gender gender = get(gender1.getId());
        if (gender != null) {
            genderRep.delete(gender);
            return create(gender1);
        }
        return null;
    }

    @Override
    public Gender read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Gender gender = get(id);
        if (gender != null) {
            genderRep.delete(gender);
            return true;
        }
        return false;
    }

    @Override
    public List<Gender> readAll() {
        return genderRep.findAll();
    }

    @Override
    public Gender get(String id) {
        Optional<Gender> genderOptional = genderRep.findById(id);
        return genderOptional.orElse(null);
    }

    @Override
    public List<Gender> readAllOf(String id) {
        return null;
    }
}
