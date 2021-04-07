package com.example.topdownrest.service;

import com.example.topdownrest.domain.MLModel;
import com.example.topdownrest.repository.ModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public MLModel getModelDetails(String modelName) {
        return modelRepository.findByModelName(modelName);
    }
}
