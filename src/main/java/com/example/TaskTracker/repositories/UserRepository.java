package com.example.TaskTracker.repositories;
import com.example.TaskTracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
