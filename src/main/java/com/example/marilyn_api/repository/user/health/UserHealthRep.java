package com.example.marilyn_api.repository.user.health;

import com.example.marilyn_api.Domain.user.health.UserHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHealthRep extends JpaRepository<UserHealth,String> {
}
