package com.example.marilyn_api.service.user;

import com.example.marilyn_api.Domain.user.Account;
import com.example.marilyn_api.repository.user.AccountRep;
import com.example.marilyn_api.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements Iservice<Account,String> {
    @Autowired
    private AccountRep accountRep;
    private static AccountService accountService;

    public static AccountService getAccountService() {
        if (accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }

    @Override
    public Account create(Account account) {
        return accountRep.save(account);
    }

    @Override
    public Account update(Account account) {
        Account account1 = get(account.getEmail());
        if (account1 != null) {
            delete(account1.getEmail());
            return create(account);
        }
        return null;
    }

    @Override
    public Account read(String id) {
        return get(id);
    }

    @Override
    public Boolean delete(String id) {
        Account account1 = get(id);
        if (account1 != null) {
            delete(account1.getEmail());
            return true;
        }
        return false;
    }

    @Override
    public List<Account> readAll() {
        return accountRep.findAll();
    }

    @Override
    public Account get(String id) {
        Optional<Account> accountOptional = accountRep.findById(id);
        return accountOptional.orElse(null);
    }

    /****
     * here we will return all the account of a specific stat of account
     * @param id
     * @return
     */
    @Override
    public List<Account> readAllOf(String id) {
        List<Account> accountList = new ArrayList<>();
        for(Account account: readAll()){
            if(account.getStat().equals(id)){
                accountList.add(account);
            }
        }
        return accountList;
    }
}
