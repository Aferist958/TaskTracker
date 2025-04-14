package com.example.TaskTracker.services;
import com.example.TaskTracker.entities.Task;
import java.util.List;
import java.util.Set;

public interface TaskService {
    List<Task> getAllTasks();
    Task createTask(Task task, Long userid, Set<Long> labelids);
    Task getTaskById(Long id);
    Task updateTask(Long id, Task task, Long userid, Set<Long> labelids);
    void deleteTask(Long id);
}
