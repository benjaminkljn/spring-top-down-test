package com.example.topdownrest.service;

import com.example.topdownrest.domain.MLModel;
import com.example.topdownrest.repository.ModelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

// TODO: Write Unit Test
@ExtendWith(MockitoExtension.class)
class ModelServiceTest {
    @Mock
    private ModelRepository modelRepository;

    @InjectMocks
    private ModelService modelService;

    @Test
    public void getModelDetailsTest() {
        MLModel mlModel = new MLModel("fakeModelName", "randomForest", "1", "COMPLETE");
        when(modelRepository.findByModelName(any(String.class))).thenReturn(mlModel);

        MLModel actual = modelService.getModelDetails(mlModel.getModelName());
        assertThat(mlModel.getModelName()).isEqualTo(actual.getModelName());
    }
}
