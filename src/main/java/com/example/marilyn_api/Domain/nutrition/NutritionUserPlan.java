package com.example.marilyn_api.Domain.nutrition;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class NutritionUserPlan {
    @Id
    private String id;
    private String email;
    private String nutritionId;
    private String subdscriptionid;
    private Date date;

    public NutritionUserPlan() {
    }
    public NutritionUserPlan(Builder builder) {
        this.date = builder.date;
        this.email = builder.email;
        this.id = builder.id;
        this.nutritionId = builder.nutritionId;
        this.subdscriptionid = builder.subdscriptionid;
    }

    public String getNutritionId() {
        return nutritionId;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSubdscription() {
        return subdscriptionid;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String email;
        private String nutritionId;
        private String subdscriptionid;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }
        public Builder buildNutrition(String nutritionId){
            this.nutritionId = nutritionId;
            return this;
        }
        public Builder buildSubscriptionId(String subdscriptionid){
            this.subdscriptionid = subdscriptionid;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public NutritionUserPlan build(){
            return new NutritionUserPlan(this);
        }
    }
}
