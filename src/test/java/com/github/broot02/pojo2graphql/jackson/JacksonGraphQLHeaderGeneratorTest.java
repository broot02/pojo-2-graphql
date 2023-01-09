package com.github.broot02.pojo2graphql.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;


public class JacksonGraphQLHeaderGeneratorTest {

    private JacksonGraphQLHeaderGenerator generator;
    private JsonGenerator jsonGenerator;
    private Writer writer;

    @Before
    public void setUp() {
        try {
            writer = new StringWriter();
            jsonGenerator = new JsonFactory().createGenerator(writer);
            generator = new JacksonGraphQLHeaderGenerator(jsonGenerator);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Should_Match_Generated_GraphQL_Text() {
        try {
            generator.generateHeaderInfo("test");
            jsonGenerator.flush();
            Assert.assertEquals("mutation ()", writer.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}