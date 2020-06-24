package com.example.marilyn_api.Domain.user.subscription;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PayType {
    @Id
    private String id;
    private String payType;
    private String description;

    private PayType() {
    }
    public PayType(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
        this.payType = builder.payType;
    }

    public String getId() {
        return id;
    }

    public String getPayType() {
        return payType;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String payType;
        private String description;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildPayType(String payType){
            this.payType = payType;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public PayType build(){
            return new PayType(this);
        }
    }
}
