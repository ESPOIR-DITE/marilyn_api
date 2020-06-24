package com.example.marilyn_api.Domain.workout;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WorkOutPlan {
    @Id
    private String id;
    private String email;
    private String subscriptionId;
    private Date date;

    public WorkOutPlan() {
    }
    public WorkOutPlan(Builder builder) {
        this.date = builder.date;
        this.email = builder.email;
        this.id = builder.id;
        this.subscriptionId = builder.subscriptionId;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String id;
        private String email;
        private String subscriptionId;
        private Date date;
        public Builder(String id){
            this.id = id;
        }
        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }
        public Builder buildSubscription(String subscriptionId){
            this.subscriptionId = subscriptionId;
            return this;
        }
        public Builder buildDate(Date date){
            this.date = date;
            return this;
        }
        public WorkOutPlan build(){
            return new WorkOutPlan(this);
        }
    }
}
