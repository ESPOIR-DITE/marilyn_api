package com.example.marilyn_api.service.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.NutritionSubscription;
import com.example.marilyn_api.repository.user.subscription.NutritionSubcriptionRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NutritionSubscriptionService implements Iservice<NutritionSubscription,String> {
    private static NutritionSubscriptionService nutritionSubscriptionService;
    @Autowired
    private NutritionSubcriptionRep nutritionSubcriptionRep;

    public static NutritionSubscriptionService getNutritionSubscriptionService() {
        if (nutritionSubscriptionService == null) {
            nutritionSubscriptionService = new NutritionSubscriptionService();
        }
        return nutritionSubscriptionService;
    }

    @Override
    public NutritionSubscription create(NutritionSubscription nutritionSubscription) {
        return nutritionSubcriptionRep.save(nutritionSubscription);
    }

    @Override
    public NutritionSubscription update(NutritionSubscription nutritionSubscription) {
        NutritionSubscription nutritionSubscription1 = get(nutritionSubscription.getId());
        if (nutritionSubscription1 != null) {
            delete(nutritionSubscription1.getId());
            return create(nutritionSubscription);
        }
        return null;
    }

    @Override
    public NutritionSubscription read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        NutritionSubscription nutritionSubscription1 = get(id);
        if (nutritionSubscription1 != null) {
            delete(nutritionSubscription1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<NutritionSubscription> readAll() {
        return nutritionSubcriptionRep.findAll();
    }

    @Override
    public NutritionSubscription get(String id) {
        Optional<NutritionSubscription> nutritionSubscriptionOptional = nutritionSubcriptionRep.findById(id);
        return nutritionSubscriptionOptional.orElse(null);
    }

    /***
     * we us the payment type Id to get all the nutrition's Objects that links to the that payment type
     * @param id
     * @return
     */
    @Override
    public List<NutritionSubscription> readAllOf(String id) {
        List<NutritionSubscription> nutritionSubscriptionList = new ArrayList<>();
        for(NutritionSubscription nutritionSubscription: readAll()){
            if(nutritionSubscription.getPaymentType().equals(id)){
                nutritionSubscriptionList.add(nutritionSubscription);
            }
        }
        return nutritionSubscriptionList;
    }
}
