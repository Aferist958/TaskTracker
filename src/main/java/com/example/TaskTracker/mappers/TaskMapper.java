package com.example.TaskTracker.mappers;

import com.example.TaskTracker.dto.TaskDTO;
import com.example.TaskTracker.entities.Label;
import com.example.TaskTracker.entities.Task;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskDTO toDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId((task.getId()));
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setCreated_at(task.getCreated_at());
        if (task.getUser() != null) {
            dto.setUser(task.getUser().getId());
        }
        if (task.getLabels() != null) {
            dto.setLabels(task.getLabels().stream().map(Label::getId).collect(Collectors.toSet()));
        }
        return dto;
    }

    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId((dto.getId()));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setCreated_at(dto.getCreated_at());
        return task;
    }
}
