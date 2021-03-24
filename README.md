## Top Down Spring MVC TDD Test
:cold_sweat: **YOUR PROBLEM:** You've been given an application that is nowhere near finished. There is missing logic in classes and missing tests.

:facepunch: **YOUR GOAL:** Fix the application!

:man_student: **YOUR JOURNEY:** Fill in logic to classes and all tests!

:white_check_mark: **YOUR ACCEPTANCE:** `TopDownRestIntegrationTest` passes along with your implemented tests.

### Requirements
You can use anything you need. Google, Bing, Yahoo, AskJeeves -- anything!

### Run Locally (Full Integration Test)
Start docker postgres container
```
docker run --name test-postgres -e POSTGRES_USER=mlmodel -e POSTGRES_PASSWORD=test -p 5432:5432 -d postgres
```

Connect to postgres and insert data
```
psql -h localhost -p 5432 -U mlmodel mlmodel
password: test

CREATE TABLE mlmodel(id SERIAL, model_name TEXT, type TEXT, version TEXT, status TEXT);
INSERT INTO mlmodel(model_name, type, version, status) VALUES ('FakeModel', 'Neural Network', '1', 'VALID');
```

Compile and run application
```
./gradlew clean build
java -jar build/libs/*.jar --spring.profiles.active=develop
```

Query model data from endpoint
```
curl http://localhost:8080/mlmodel/FakeModel
```