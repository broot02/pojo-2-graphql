package com.github.broot02.pojo2graphql.core.serialization;

import com.github.broot02.pojo2graphql.core.models.GraphQLModel;

public interface GraphQLStrategyFactory {
    <T extends GraphQLModel<?,?>> GraphQLQueryGenerator createQueryGenerator(T t);
    <T extends GraphQLModel<?,?>> GraphQLVariableGenerator createVariableGenerator(T t);
}
