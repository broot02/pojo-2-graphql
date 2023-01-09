package com.github.broot02.pojo2graphql.core.serialization;

public interface GraphQLQueryGenerator {
    <T> void generateQueryInfo(T t);
}
