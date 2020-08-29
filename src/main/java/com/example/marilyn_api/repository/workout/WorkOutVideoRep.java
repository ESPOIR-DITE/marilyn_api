package com.example.marilyn_api.repository.workout;

import com.example.marilyn_api.Domain.workout.WorkExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOutVideoRep extends JpaRepository<WorkExercise,String> {
}
