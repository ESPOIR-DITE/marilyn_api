package com.example.marilyn_api.Domain.user.subscription;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PayDetails {
    @Id
    private String id;
    private String payTypeId;
    private String account;
    private String bank;
    private String description;

    private PayDetails() {
    }
    public PayDetails(Builder builder) {
        this.id = builder.id;
        this.account = builder.account;
        this.bank = builder.bank;
        this.payTypeId = builder.payTypeId;
        this.description = builder.description;
    }

    public String getId() {
        return id;
    }

    public String getPayTypeId() {
        return payTypeId;
    }

    public String getAccount() {
        return account;
    }

    public String getBank() {
        return bank;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String payTypeId;
        private String account;
        private String bank;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildPayTypeId(String payTypeId){
            this.payTypeId = payTypeId;
            return this;
        }
        public Builder buildAccount(String account){
            this.account = account;
            return this;
        }
        public Builder buildBank(String bank){
            this.bank = bank;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public PayDetails build(){
            return new PayDetails(this);
        }
    }

}
