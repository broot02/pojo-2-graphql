package com.github.broot02.pojo2graphql.core.serialization;

public interface GraphQLVariableGenerator {

    <T> void generateVariableInfo(T t);
}
