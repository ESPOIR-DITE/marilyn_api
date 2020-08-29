package com.example.marilyn_api.service.nutrition.food;

import com.example.marilyn_api.Domain.nutrition.food.FoodImage;
import com.example.marilyn_api.repository.nutrition.food.FoodImageRepository;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodImageService implements Iservice<FoodImage,String> {
    @Autowired
    private FoodImageRepository foodImageRepository;
    private static FoodImageService foodImageService;

    public static FoodImageService getFoodImageService() {
        if (foodImageService == null) {
            foodImageService = new FoodImageService();
        }
        return foodImageService;
    }

    @Override
    public FoodImage create(FoodImage foodImage) throws IOException {
        return foodImageRepository.save(foodImage);
    }

    @Override
    public FoodImage update(FoodImage foodImage) throws IOException {
        return foodImageRepository.save(foodImage);
    }

    @Override
    public FoodImage read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        FoodImage foodImage = get(id);
        if (foodImage != null) {
            foodImageRepository.delete(foodImage);
            return true;
        }
        return false;
    }

    @Override
    public List<FoodImage> readAll() {
        return foodImageRepository.findAll();
    }

    @Override
    public FoodImage get(String id) {
        Optional<FoodImage> imageOptional = foodImageRepository.findById(id);
        return imageOptional.orElse(null);
    }

    @Override
    public List<FoodImage> readAllOf(String id) {
        List<FoodImage> foodImages = new ArrayList<>();
        for(FoodImage foodImage: readAll()){
            if (foodImage.getFoodId().equals(id)) {
                foodImages.add(foodImage);
            }
        }
        return foodImages;
    }
}
