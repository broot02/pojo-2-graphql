package com.github.broot02.pojo2graphql.core.serialization;

import com.github.broot02.pojo2graphql.core.models.GraphQLModel;

public interface GraphQLVariableGenerator {

    <T extends GraphQLModel<?,?>> void generateVariableInfo(T t);
}
