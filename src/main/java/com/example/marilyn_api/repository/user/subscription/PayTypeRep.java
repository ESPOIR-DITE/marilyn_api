package com.example.marilyn_api.repository.user.subscription;

import com.example.marilyn_api.Domain.user.subscription.PayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayTypeRep extends JpaRepository<PayType,String> {
}
