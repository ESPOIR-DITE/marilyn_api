package com.example.marilyn_api.controller.user;

import com.example.marilyn_api.Domain.user.Account;
import com.example.marilyn_api.controller.Icontroller;
import com.example.marilyn_api.service.user.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fcma/account")
public class AccountController implements Icontroller<Account,String> {
    @Autowired
    private AccountService accountService;

    @PostMapping("create")
    @Override
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }
    @GetMapping("read")
    @Override
    public Account read(String id) {
        return accountService.read(id);
    }
    @PostMapping("update")
    @Override
    public Account update(Account account) {
        return accountService.update(account);
    }
    @GetMapping("delete")
    @Override
    public Boolean delete(String id) {
        return accountService.delete(id);
    }
    @GetMapping("readAll")
    @Override
    public List<Account> readALl() {
        return accountService.readAll();
    }
    /****
     * here we will return all the account of a specific stat of account
     * @param id
     * @return
     */
    @Override
    public List<Account> readALlOff(String id) {
        return accountService.readAllOf(id);
    }
}
