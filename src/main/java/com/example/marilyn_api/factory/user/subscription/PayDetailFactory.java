package com.example.marilyn_api.factory.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.PayDetails;
import com.example.marilyn_api.util.GeneratId;

public class PayDetailFactory {
    public static PayDetails getPayDetail( String payTypeId,String account,String bank,String description){
        return new PayDetails.Builder(GeneratId.getId(PayDetailFactory.class))
                .buildAccount(account).buildBank(bank)
                .buildDescription(description)
                .buildPayTypeId(payTypeId)
                .build();
    }
}
