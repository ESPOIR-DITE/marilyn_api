package com.example.marilyn_api.Domain.user.subscription;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class NutritionSubscription {
    @Id
    private String id;
    private double amount;
    private Date date;

    private NutritionSubscription() {
    }
    public NutritionSubscription(Builder builder) {
        this.amount = builder.amount;
        this.date = builder.date;
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private double amount;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildAmount(double amount){
            this.amount = amount;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public NutritionSubscription build(){
            return new NutritionSubscription(this);
        }
    }
}
