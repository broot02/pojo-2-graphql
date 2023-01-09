package com.github.broot02.pojo2graphql.core.models;

public abstract class GraphQLModel<T, V> {

    private String operationName;
    private T requestSchema;
    private V requestVariables;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public T getRequestSchema() {
        return requestSchema;
    }

    public void setRequestSchema(T requestSchema) {
        this.requestSchema = requestSchema;
    }

    public V getRequestVariables() {
        return requestVariables;
    }

    public void setRequestVariables(V requestVariables) {
        this.requestVariables = requestVariables;
    }
}
