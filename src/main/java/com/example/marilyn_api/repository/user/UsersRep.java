package com.example.marilyn_api.repository.user;

import com.example.marilyn_api.Domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRep extends JpaRepository<Users,String> {
}
