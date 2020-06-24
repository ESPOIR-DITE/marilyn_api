package com.example.marilyn_api.factory.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.PayType;
import com.example.marilyn_api.util.GeneratId;

public class PayTypeFactory {
    public static PayType getPayType(String payType,String description){
        return new PayType.Builder(GeneratId.getId(PayTypeFactory.class))
                .buildPayType(payType)
                .buildDescription(description)
                .build();
    }
}
