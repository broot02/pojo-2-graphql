package com.github.broot02.pojo2graphql.jackson;

import com.github.broot02.pojo2graphql.core.models.GraphQLModel;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLVariableGenerator;

public class JacksonGraphQLVariableGenerator implements GraphQLVariableGenerator {
    @Override
    public <T extends GraphQLModel<?,?>> void generateVariableInfo(T t) {

    }
}
