package com.example.marilyn_api.repository.user.health;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Health extends JpaRepository<Health,String> {
}
