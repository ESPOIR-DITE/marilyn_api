package com.example.marilyn_api.repository.workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOutVideo extends JpaRepository<WorkOutVideo,String> {
}
