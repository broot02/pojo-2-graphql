package com.github.broot02.pojo2graphql.query.models;

import com.github.broot02.pojo2graphql.core.models.GraphQLModel;

public class GraphQLQuery<T,V> extends GraphQLModel<T,V> {
    public GraphQLQuery(Class<T> t) {
        super(t);
    }
}
