package com.example.TaskTracker.repositories;
import com.example.TaskTracker.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}
