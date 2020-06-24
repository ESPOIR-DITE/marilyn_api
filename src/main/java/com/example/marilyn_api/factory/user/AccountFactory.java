package com.example.marilyn_api.factory.user;

import com.example.marilyn_api.Domain.user.Account;

import java.util.Date;

public class AccountFactory {
    public static Account getAccount(String email,String password,String stat,Date date){
        return new Account.Builder(email).build(date).buildPassword(password).buildStat(stat).build();
    }
}
