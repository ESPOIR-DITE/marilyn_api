package com.example.marilyn_api.repository;

import com.example.marilyn_api.Domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRep extends JpaRepository<Gender,String> {
}
