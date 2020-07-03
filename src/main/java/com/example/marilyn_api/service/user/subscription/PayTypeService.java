package com.example.marilyn_api.service.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.PayDetails;
import com.example.marilyn_api.Domain.user.subscription.PayType;
import com.example.marilyn_api.repository.user.subscription.PayDatailsRep;
import com.example.marilyn_api.repository.user.subscription.PayTypeRep;
import com.example.marilyn_api.service.Iservice;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayTypeService implements Iservice<PayType,String> {
    private static PayTypeService payTypeService;
    @Autowired
    private PayTypeRep payTypeRep;

    public static PayTypeService getPayTypeService() {
        if (payTypeService != null) {
            payTypeService =new  PayTypeService();
        }
        return payTypeService;
    }


    @Override
    public PayType create(PayType payType) {
        return payTypeRep.save(payType);
    }

    @Override
    public PayType update(PayType payType) {
        PayType payType1 = get(payType.getId());
        if (payType1 != null) {
            delete(payType1.getId());
            return create(payType);
        }
        return null;
    }

    @Override
    public PayType read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        PayType payType1 = get(id);
        if (payType1 != null) {
            delete(payType1.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<PayType> readAll() {
        return payTypeRep.findAll();
    }

    @Override
    public PayType get(String id) {
        Optional<PayType> payTypeOptional = payTypeRep.findById(id);
        return payTypeOptional.orElse(null);
    }

    @Override
    public List<PayType> readAllOf(String id) {
        return null;
    }
}
