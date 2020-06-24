package com.example.marilyn_api.Domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Account {
    @Id
    private String email;
    private String password;
    private String stat;
    private Date date;

    private Account() {
    }
    public Account(Builder builder) {
        this.date = builder.date;
        this.email = builder.email;
        this.password = builder.password;
        this.stat = builder.stat;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStat() {
        return stat;
    }

    public Date getDate() {
        return date;
    }
    public static class Builder{
        private String email;
        private String password;
        private String stat;
        private Date date;
        public Builder(String email){
            this.email = email;
        }
        public Builder buildPassword(String password){
            this.password = password;
            return this;
        }
        public Builder buildStat(String stat){
            this.stat = stat;
            return this;
        }
        public Builder build(Date date){
            this.date = date;
            return this;
        }
        public Account build(){
            return new Account(this);
        }
    }
}
