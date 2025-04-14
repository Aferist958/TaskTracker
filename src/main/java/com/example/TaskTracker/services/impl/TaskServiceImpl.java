package com.example.TaskTracker.services.impl;
import com.example.TaskTracker.entities.Label;
import com.example.TaskTracker.entities.Task;
import com.example.TaskTracker.entities.User;
import com.example.TaskTracker.repositories.LabelRepository;
import com.example.TaskTracker.repositories.TaskRepository;
import com.example.TaskTracker.repositories.UserRepository;
import com.example.TaskTracker.services.LabelService;
import com.example.TaskTracker.services.TaskService;
import com.example.TaskTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task, Long userid, Set<Long> labelids) {
        if (userid != null) {
            User user = userService.getUserById(userid);
            task.setUser(user);
        }
        if (labelids != null) {
            List<Label> list_labels = labelRepository.findAllById(labelids);
            Set<Label> set_labels = new HashSet<>(list_labels);
            task.setLabels(set_labels);
        }
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = null;
        if (optionalTask.isPresent()) {
            task = optionalTask.get();
        } else {
            throw new RuntimeException("Task not found for id : " + id);
        }
        return task;
    }

    @Override
    public Task updateTask(Long id, Task task, Long userid, Set<Long> labelids) {
        Task targetTask = getTaskById(id);
        targetTask.setTitle(task.getTitle());
        targetTask.setDescription(task.getDescription());
        targetTask.setStatus(task.getStatus());
        if (userid != null) {
            User user = userService.getUserById(userid);
            targetTask.setUser(user);
        } else {
            targetTask.setUser(null);
        }
        if (labelids != null) {
            List<Label> list_labels = labelRepository.findAllById(labelids);
            Set<Label> set_labels = new HashSet<>(list_labels);
            targetTask.setLabels(set_labels);
        } else {
            targetTask.setLabels(null);
        }
        return taskRepository.save(targetTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
