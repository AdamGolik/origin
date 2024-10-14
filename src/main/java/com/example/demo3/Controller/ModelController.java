package com.example.demo3.Controller;

import com.example.demo3.Model.Model;
import com.example.demo3.Service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Model>> getAllModels() {
        Iterable<Model> models = modelService.getAllModels();
        return ResponseEntity.ok(models);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable Long id) {
        Optional<Model> model = modelService.getModelById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Long id, @RequestBody Model model) {
        Optional<Model> updatedModel = modelService.updateModel(id, model);
        return updatedModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Model> createModel(@RequestBody Model model) {
        Model savedModel = modelService.saveModel(model);
        if(savedModel == null || savedModel.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(savedModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long id) {
        boolean deleted = modelService.deleteModel(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}