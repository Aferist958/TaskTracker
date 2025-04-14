package com.example.TaskTracker.repositories;
import com.example.TaskTracker.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
