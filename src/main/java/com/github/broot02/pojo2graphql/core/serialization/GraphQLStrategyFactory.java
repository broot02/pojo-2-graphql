package com.github.broot02.pojo2graphql.core.serialization;

public interface GraphQLStrategyFactory {
    <T> GraphQLHeaderGenerator createHeaderGenerator(T t);
    <T> GraphQLQueryGenerator createQueryGenerator(T t);
    <T> GraphQLVariableGenerator createVariableGenerator(T t);
}
