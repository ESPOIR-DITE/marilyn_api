package com.example.marilyn_api.service.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.PayDetails;
import com.example.marilyn_api.repository.user.subscription.PayDatailsRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayDatailsService implements Iservice<PayDetails,String> {
    private static PayDatailsService payDatailsService;
    @Autowired
    private PayDatailsRep payDatailsRep;

    public static PayDatailsService getPayDatailsService() {
        if (payDatailsService == null) {
            payDatailsService = new PayDatailsService();
        }
        return payDatailsService;
    }

    @Override
    public PayDetails create(PayDetails payDetails) {
        return payDatailsRep.save(payDetails);
    }

    @Override
    public PayDetails update(PayDetails payDetails) {
        PayDetails payDetails1 = get(payDetails.getId());
        if (payDetails1 != null) {
            delete(payDetails1.getId());
            return create(payDetails);
        }
        return null;
    }

    @Override
    public PayDetails read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        PayDetails payDetails1 = get(id);
        if (payDetails1 != null) {
            delete(payDetails1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<PayDetails> readAll() {
        return payDatailsRep.findAll();
    }

    @Override
    public PayDetails get(String id) {
        Optional<PayDetails> payDetailsOptional = payDatailsRep.findById(id);
        return payDetailsOptional.orElse(null);
    }

    @Override
    public List<PayDetails> readAllOf(String id) {
        return null;
    }
}
