package com.example.topdownrest.domain;

public class MLModel {

    private String modelName;
    private String type;
    private String version;
    private String status;

    public MLModel() {}

    public MLModel(String modelName, String type, String version, String status) {
        this.modelName = modelName;
        this.type = type;
        this.version = version;
        this.status = status;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public String getStatus() {
        return this.status;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
