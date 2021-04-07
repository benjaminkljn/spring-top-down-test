package com.example.topdownrest.controller;

import com.example.topdownrest.domain.MLModel;
import com.example.topdownrest.exception.ModelNotFoundException;
import com.example.topdownrest.service.ModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Missing one key item in this class to make it work
@RestController
@RequestMapping("/mlmodel")
public class MLModelController {

    private final ModelService modelService;

    public MLModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/{modelName}")
    public MLModel getModel(@PathVariable String modelName) {
        MLModel modelDetails = modelService.getModelDetails(modelName);
        if (modelDetails == null) {
            throw new ModelNotFoundException();
        }
        return modelDetails;
    }

}
