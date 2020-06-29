package com.example.marilyn_api.repository.user;

import com.example.marilyn_api.Domain.user.UserGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGenderRep extends JpaRepository<UserGender,String> {
}
