package com.example.marilyn_api.repository;

import com.example.marilyn_api.Domain.Videos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRep extends JpaRepository<Videos,String> {
}
