package com.example.TaskTracker.controllers;

import com.example.TaskTracker.entities.Label;
import com.example.TaskTracker.entities.User;
import com.example.TaskTracker.services.LabelService;
import com.example.TaskTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping
    public List<Label> getAllLabel() {
        return labelService.getAllLabels();
    }

    @PostMapping
    public Label createLabel(@RequestBody Label label) {
        return labelService.createLabel(label);
    }

    @GetMapping("/{id}")
    public Label getLabelById(@PathVariable Long id) {
        return labelService.getLabelById(id);
    }

    @PutMapping("/{id}")
    public Label updateLabel(@PathVariable Long id, @RequestBody Label label) {
        return labelService.updateLabel(id, label);
    }

    @DeleteMapping("/{id}")
    public void deleteLabel(@PathVariable Long id) {
        labelService.deleteLabel(id);
    }
}
