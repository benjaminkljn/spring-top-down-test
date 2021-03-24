package com.example.topdownrest;

import com.example.topdownrest.domain.MLModel;
import com.example.topdownrest.repository.ModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopDownRestIntegrationTest {
    // What are we wanting this app to do?
    /*
    Given a running app
When I query a GET <host>/model/{modelName}
Then I get a HTTP 200 and the resulting data {"modelName":"<name>","type":"<type>","version":"<version>","status":"<status>"}
     */

    /*
     Application Architecture:
     Client -> Controller -> Service -> Repository
     */

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ModelRepository modelRepository;

    @Test
    public void testModelData_givenValidMLModel_returnsMLModel() {
        // arrange
        modelRepository.saveAndFlush(new MLModel("fakeModelName","randomForest","1","COMPLETE"));

        // act
        ResponseEntity<MLModel> result = testRestTemplate.getForEntity("/mlmodel/fakeModelName", MLModel.class);

        // assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getModelName()).isEqualTo("fakeModelName");
        assertThat(result.getBody().getType()).isEqualTo("randomForest");
        assertThat(result.getBody().getVersion()).isEqualTo("1");
        assertThat(result.getBody().getStatus()).isEqualTo("COMPLETE");
    }

    @Test
    public void testModelData_givenNotFoundMLModel_returns404() {
        ResponseEntity<MLModel> result = testRestTemplate.getForEntity("/mlmodel/fakeModelName", MLModel.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
