package com.example.marilyn_api.repository.workout;

import com.example.marilyn_api.Domain.workout.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOutTypeRep extends JpaRepository<WorkoutType,String> {
}
