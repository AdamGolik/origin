package com.example.demo3.Service;

import com.example.demo3.Model.Model;
import com.example.demo3.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public Iterable<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }

    public Optional<Model> updateModel(Long id, Model model) {
        if (modelRepository.existsById(id)) {
            model.setId(id);
            return Optional.of(modelRepository.save(model));
        } else {
            return Optional.empty();
        }
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public boolean deleteModel(Long id) {
        if (modelRepository.existsById(id)) {
            modelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Iterable<Model> getFilteredModels(String filter) {
        // Implementacja filtrowania w repozytorium według specyficznych kryteriów
        return modelRepository.findBySomeCriteria(filter);
    }
}