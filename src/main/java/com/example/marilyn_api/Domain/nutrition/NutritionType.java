package com.example.marilyn_api.Domain.nutrition;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class NutritionType {
    @Id
    private String id;
    private String nutritionType;
    private Date date;

    private NutritionType() {
    }
    public NutritionType(Builder builder) {
        this.date = builder.date;
        this.id = builder.id;
        this.nutritionType = builder.nutritionType;
    }

    public String getId() {
        return id;
    }

    public String getNutritionType() {
        return nutritionType;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String nutritionType;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildNutritionType(String nutritionType){
            this.nutritionType = nutritionType;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public NutritionType build(){
            return new NutritionType(this);
        }
    }
}
