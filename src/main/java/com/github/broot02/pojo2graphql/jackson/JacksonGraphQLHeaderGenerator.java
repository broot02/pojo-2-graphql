package com.github.broot02.pojo2graphql.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLHeaderGenerator;

import java.io.IOException;

public class JacksonGraphQLHeaderGenerator implements GraphQLHeaderGenerator {

    private final JsonGenerator jsonGenerator;

    public JacksonGraphQLHeaderGenerator(JsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @Override
    public <T> void generateHeaderInfo(T t) {
        try {
            jsonGenerator.writeRaw("mutation ()");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
