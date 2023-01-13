package com.github.broot02.pojo2graphql.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.broot02.pojo2graphql.core.models.GraphQLModel;

import java.io.IOException;

public class GraphQLQuerySerializer<T extends GraphQLModel<?,?>> extends StdSerializer<T> {
    protected GraphQLQuerySerializer(Class<T> t) {
        super(t);
    }

    @Override
    public void serialize(T graphQLQuery, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    }
}
