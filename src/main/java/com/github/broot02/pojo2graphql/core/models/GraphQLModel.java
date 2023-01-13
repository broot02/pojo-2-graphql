package com.github.broot02.pojo2graphql.core.models;

public abstract class GraphQLModel<T, V> {

    private String operationName;
    private Class<T> requestSchema;
    private V requestVariables;

    protected GraphQLModel(Class<T> requestSchema) {
        this.requestSchema = requestSchema;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }


    public V getRequestVariables() {
        return requestVariables;
    }

    public void setRequestVariables(V requestVariables) {
        this.requestVariables = requestVariables;
    }

    public Class<T> getRequestSchema() {
        return requestSchema;
    }

    public void setRequestSchema(Class<T> requestSchema) {
        this.requestSchema = requestSchema;
    }
}
