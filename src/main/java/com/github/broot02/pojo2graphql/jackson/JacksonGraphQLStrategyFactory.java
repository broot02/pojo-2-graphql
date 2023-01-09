package com.github.broot02.pojo2graphql.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLHeaderGenerator;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLQueryGenerator;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLStrategyFactory;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLVariableGenerator;

public class JacksonGraphQLStrategyFactory implements GraphQLStrategyFactory {

    private final JsonGenerator jsonGenerator;

    public JacksonGraphQLStrategyFactory(JsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @Override
    public <T> GraphQLHeaderGenerator createHeaderGenerator(T t) {
        return null;
    }

    @Override
    public <T> GraphQLQueryGenerator createQueryGenerator(T t) {
        return null;
    }

    @Override
    public <T> GraphQLVariableGenerator createVariableGenerator(T t) {
        return null;
    }
}
