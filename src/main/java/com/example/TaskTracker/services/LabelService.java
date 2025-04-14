package com.example.TaskTracker.services;
import com.example.TaskTracker.entities.Label;
import java.util.List;

public interface LabelService {
    List<Label> getAllLabels();
    Label createLabel(Label label);
    Label getLabelById(Long id);
    Label updateLabel(Long id, Label label);
    void deleteLabel(Long id);
}
