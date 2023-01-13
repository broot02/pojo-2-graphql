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

        stringBuilder.append("{").append(System.lineSeparator());
        addSchemaFieldsToQuery(stringBuilder, t.getRequestSchema(), 0);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private void addSchemaFieldsToQuery(StringBuilder builder, Class<?> classType, int padding) {
        for (int i = 0; i < classType.getDeclaredFields().length; i++) {
            Field field = classType.getDeclaredFields()[i];
            for (int size = 0; size <= padding; size++) {
                builder.append("  ");
            }

            if (field.getType().isPrimitive() || field.getType().isAssignableFrom(String.class)) {
                builder.append(field.getName()).append(System.lineSeparator());
            } else if (field.getType().isArray()) {
                addObjectToSchema(builder, field.getName(), field.getType().getComponentType(), padding, i);
            } else {
                addObjectToSchema(builder, field.getName(), field.getType(), padding, i);
            }
        }
    }

    private void addObjectToSchema(StringBuilder builder, String name, Class<?> type, int padding, int index) {
        builder.append(name).append(BEGIN_OBJECT_PADDING).append(System.lineSeparator());
        addSchemaFieldsToQuery(builder, type, index);
        for (int size = 0; size <= padding; size++) {
            builder.append("  ");
        }
        builder.append(END_OBJECT).append(System.lineSeparator());
    }
}
