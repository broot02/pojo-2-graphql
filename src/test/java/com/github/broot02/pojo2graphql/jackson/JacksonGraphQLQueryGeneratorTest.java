package com.github.broot02.pojo2graphql.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.github.broot02.pojo2graphql.fakes.FakeGraphQLQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;


public class JacksonGraphQLQueryGeneratorTest {

    private JacksonGraphQLQueryGenerator generator;
    private JsonGenerator jsonGenerator;
    private Writer writer;

    private Path workingDir;

    @Before
    public void setUp() {
        try {
            writer = new StringWriter();
            jsonGenerator = new JsonFactory().createGenerator(writer);
            generator = new JacksonGraphQLQueryGenerator(jsonGenerator);
            this.workingDir = Path.of("", "src/test/resources");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Should_Match_Generated_GraphQL_Text() {
        String expected = "{\"query\":\"{\\r\\n  id\\r\\n  model\\r\\n  account {\\r\\n      id\\r\\n      name\\r\\n      sequence\\r\\n      user {\\r\\n        id\\r\\n        username\\r\\n        properties {\\r\\n      id\\r\\n      name\\r\\n        }\\r\\n      }\\r\\n  }\\r\\n}\"}";
        Path file = this.workingDir.resolve("queries/FakeGraphQLQuery.txt");
        try {
            expected = Files.readString(file);;
            jsonGenerator.writeStartObject();
            generator.generateQueryInfo(new FakeGraphQLQuery());
            jsonGenerator.writeEndObject();
            jsonGenerator.flush();
            assertEquals(expected, writer.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}