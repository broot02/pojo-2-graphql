package com.github.broot02.pojo2graphql.core.serialization;

import com.github.broot02.pojo2graphql.core.models.GraphQLModel;

public interface GraphQLQueryGenerator {
    <T extends GraphQLModel<?,?>> void generateQueryInfo(T t);
}
