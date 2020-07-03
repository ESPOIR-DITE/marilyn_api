package com.example.marilyn_api.service.nutrition;

import com.example.marilyn_api.Domain.nutrition.NutritionType;
import com.example.marilyn_api.repository.nutrition.NutritionTypeRep;
import com.example.marilyn_api.service.Iservice;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionTypeService implements Iservice<NutritionType,String> {
    @Autowired
    private NutritionTypeRep nutritionTypeRep;
    private static NutritionTypeService nutritionTypeService;
    @Override
    public NutritionType create(NutritionType nutritionType) {
        return nutritionTypeRep.save(nutritionType);
    }

    @Override
    public NutritionType update(NutritionType nutritionType) {
        NutritionType nutritionType1 = get(nutritionType.getId());
        if (nutritionType1 == null) {
            delete(nutritionType1.getId());
            return create(nutritionType);
        }
        return null;
    }

    @Override
    public NutritionType read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        NutritionType nutritionType1 = get(id);
        if (nutritionType1 == null) {
            delete(nutritionType1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<NutritionType> readAll() {
        return nutritionTypeRep.findAll();
    }

    @Override
    public NutritionType get(String id) {
        Optional<NutritionType> nutritionTypeOptional = nutritionTypeRep.findById(id);
        return nutritionTypeOptional.orElse(null);
    }

    @Override
    public List<NutritionType> readAllOf(String id) {
        return null;
    }
}
