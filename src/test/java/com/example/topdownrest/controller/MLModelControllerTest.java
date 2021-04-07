package com.example.topdownrest.controller;

import com.example.topdownrest.domain.MLModel;
import com.example.topdownrest.service.ModelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO: Implement Slice Test
@WebMvcTest
public class MLModelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelService modelService;

    @Test
    public void getModelTest() {
        MLModel mlModel = new MLModel("FakeModel", "Neural Network", "1", "VALID");
        when(modelService.getModelDetails(any(String.class))).thenReturn(mlModel);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/mlmodel/{modelName}", "FakeModel");

        try {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.modelName", is(mlModel.getModelName())))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
