package com.github.broot02.pojo2graphql.fakes;

import java.util.List;

public class FakeUser {

    private int id;
    private String username;
    private FakeProperties[] properties;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public FakeProperties[] getProperties() {
        return properties;
    }

    public void setProperties(FakeProperties[] properties) {
        this.properties = properties;
    }
}
