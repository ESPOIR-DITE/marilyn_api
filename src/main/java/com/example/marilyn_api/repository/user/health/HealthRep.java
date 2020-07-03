package com.example.marilyn_api.repository.user.health;

import com.example.marilyn_api.Domain.user.health.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRep extends JpaRepository<Health,String> {
}
