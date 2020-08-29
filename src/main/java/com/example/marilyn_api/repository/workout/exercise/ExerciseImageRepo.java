package com.example.marilyn_api.repository.workout.exercise;

import com.example.marilyn_api.Domain.workout.exercise.ExerciseImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseImageRepo extends JpaRepository<ExerciseImage,String> {
}
