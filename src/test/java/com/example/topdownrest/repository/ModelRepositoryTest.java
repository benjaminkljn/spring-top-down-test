package com.example.topdownrest.repository;

import com.example.topdownrest.domain.MLModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// TODO: Implement Slice Test
@DataJpaTest
class ModelRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByModelNameTest() {
        MLModel mlModel = new MLModel("fakeModelName", "randomForest", "1", "COMPLETE");
        MLModel actual = testEntityManager.persistAndFlush(mlModel);

        Assertions.assertEquals(mlModel.getModelName(), actual.getModelName());
    }
}
