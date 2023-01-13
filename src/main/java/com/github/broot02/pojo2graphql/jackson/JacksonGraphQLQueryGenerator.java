package com.github.broot02.pojo2graphql.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.broot02.pojo2graphql.core.models.GraphQLModel;
import com.github.broot02.pojo2graphql.core.serialization.GraphQLQueryGenerator;
import com.github.broot02.pojo2graphql.mutation.models.GraphQLMutation;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;

public class JacksonGraphQLQueryGenerator implements GraphQLQueryGenerator {

    private final JsonGenerator jsonGenerator;
    private static final String BEGIN_OBJECT_PADDING = " {";
    private static final String END_OBJECT = "}";

    public JacksonGraphQLQueryGenerator(JsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @Override
    public <T extends GraphQLModel<?, ?>> void generateQueryInfo(T t) {
        try {
            String body = addSchemaBody(t);
            jsonGenerator.writeStringField("query", body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private <T extends GraphQLModel<?, ?>> String addSchemaBody(T t) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        addSchemaFieldsToQuery(stringBuilder, t.getRequestSchema());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private void addSchemaFieldsToQuery(StringBuilder builder, Class<?> classType) {
        for (int i = 0; i < classType.getDeclaredFields().length; i++) {
            Field field = classType.getDeclaredFields()[i];
            if (field.getType().isPrimitive() || field.getType().isAssignableFrom(String.class)) {
                builder.append(field.getName()).append(" ");
            } else if (field.getType().isArray()) {
                addObjectToSchema(builder, field.getName(), field.getType().getComponentType());
            } else {
                addObjectToSchema(builder, field.getName(), field.getType());
            }
        }
    }

    private void addObjectToSchema(StringBuilder builder, String name, Class<?> type) {
        builder.append(name).append(" { ");
        addSchemaFieldsToQuery(builder, type);
        builder.append(END_OBJECT);
    }
}
