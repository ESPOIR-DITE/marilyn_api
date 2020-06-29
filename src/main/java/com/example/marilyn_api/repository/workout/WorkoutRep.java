package com.example.marilyn_api.repository.workout;

import com.example.marilyn_api.Domain.workout.WorkOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRep extends JpaRepository<WorkOut,String> {
}
