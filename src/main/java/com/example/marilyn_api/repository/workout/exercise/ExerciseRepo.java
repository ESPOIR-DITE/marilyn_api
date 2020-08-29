package com.example.marilyn_api.repository.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise,String> {
}
