package com.example.marilyn_api.service.user;

import com.example.marilyn_api.Domain.user.UserImage;
import com.example.marilyn_api.repository.user.UserImageRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImageService implements Iservice<UserImage,String> {
    @Autowired
    private UserImageRep userImageRep;
    private static  UserImageService userImageService;

    public static UserImageService getUserImageService() {
        if (userImageService == null) {
            userImageService = new UserImageService();
        }
        return userImageService;
    }

    @Override
    public UserImage create(UserImage userImage) {
        return userImageRep.save(userImage);
    }

    @Override
    public UserImage update(UserImage userImage) {
        UserImage userImage1 = get(userImage.getId());
        if (userImage1 != null) {
            delete(userImage1.getId());
            return create(userImage);
        }
        return null;
    }

    @Override
    public UserImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        UserImage userImage1 = get(id);
        if (userImage1 != null) {
            delete(userImage1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<UserImage> readAll() {
        return userImageRep.findAll();
    }

    @Override
    public UserImage get(String id) {
        Optional<UserImage> userImageOptional = userImageRep.findById(id);
        return userImageOptional.orElse(null);
    }

    @Override
    public List<UserImage> readAllOf(String id) {
        return null;
    }
}
