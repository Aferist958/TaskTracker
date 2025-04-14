package com.example.TaskTracker.services.impl;
import com.example.TaskTracker.entities.Label;
import com.example.TaskTracker.repositories.LabelRepository;
import com.example.TaskTracker.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;

    @Override
    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    @Override
    public Label createLabel(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label getLabelById(Long id) {
        Optional<Label> optionalLabel = labelRepository.findById(id);
        Label label = null;
        if (optionalLabel.isPresent()) {
            label = optionalLabel.get();
        } else {
            throw new RuntimeException("Label not found for id : " + id);
        }
        return label;
    }

    @Override
    public Label updateLabel(Long id, Label label) {
        Label targetLabel = getLabelById(id);
        targetLabel.setName(label.getName());
        targetLabel.setColor(label.getColor());
        return labelRepository.save(targetLabel);
    }

    @Override
    public void deleteLabel(Long id) {
        labelRepository.deleteById(id);
    }

}
