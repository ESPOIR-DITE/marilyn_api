package com.example.marilyn_api.Domain.user.subscription;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class WorkoutSubscription {
    @Id
    private String id;
    private String email;
    private String workoutPlanId;
    private Date date;
    private String paymentTypeId;

    private WorkoutSubscription() {
    }
    public WorkoutSubscription(Builder builder) {
        this.date = builder.date;
        this.id = builder.id;
        this.email = builder.email;
        this.workoutPlanId = builder.workoutPlanId;
        this.paymentTypeId = builder.paymentTypeId;
    }

    public String getPayamentTypeId() {
        return paymentTypeId;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String paymentTypeId;
        private String email;
        private String workoutPlanId;        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }
        public Builder buildWorkoutPlanId(String workoutPlanId){
            this.workoutPlanId = workoutPlanId;
            return this;
        }
        public Builder buildPaymentTypeId(String paymentTypeId){
            this.paymentTypeId = paymentTypeId;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public WorkoutSubscription build(){
            return new WorkoutSubscription(this);
        }
    }
}

