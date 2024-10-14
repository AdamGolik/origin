package com.example.demo3.Service;

import com.example.demo3.Model.Model;
import com.example.demo3.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private SchoolRepository modelRepository;

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public Iterable<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }

    public Optional<Model> updateModel(Long id, Model updatedModel) {
        return modelRepository.findById(id).map(existingModel -> {
            existingModel.setName(updatedModel.getName());
            existingModel.setLastname(updatedModel.getLastname());
            existingModel.setGrade(updatedModel.getGrade());
            return modelRepository.save(existingModel);
        });
    }

    public boolean deleteModel(Long id) {
        if (modelRepository.existsById(id)) {
            modelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}