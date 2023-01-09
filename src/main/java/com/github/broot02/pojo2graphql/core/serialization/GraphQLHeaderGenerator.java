package com.github.broot02.pojo2graphql.core.serialization;

public interface GraphQLHeaderGenerator {
    <T> void generateHeaderInfo(T t);
}
