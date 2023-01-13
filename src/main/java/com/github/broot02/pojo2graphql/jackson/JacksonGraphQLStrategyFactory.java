package com.github.broot02.pojo2graphql.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.github.broot02.pojo2graphql.core.models.GraphQLModel;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLQueryGenerator;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLStrategyFactory;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLVariableGenerator;

public class JacksonGraphQLStrategyFactory implements GraphQLStrategyFactory {

    private final JsonGenerator jsonGenerator;

    public JacksonGraphQLStrategyFactory(JsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @Override
    public <T extends GraphQLModel<?,?>> GraphQLQueryGenerator createQueryGenerator(T t) {
        return null;
    }

    @Override
    public <T extends GraphQLModel<?,?>> GraphQLVariableGenerator createVariableGenerator(T t) {
        return null;
    }
}
