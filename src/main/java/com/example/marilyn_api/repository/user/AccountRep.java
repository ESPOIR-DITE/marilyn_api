package com.example.marilyn_api.repository.user;

import com.example.marilyn_api.Domain.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRep extends JpaRepository<Account,String> {
}
