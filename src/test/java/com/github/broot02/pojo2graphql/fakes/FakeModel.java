package com.github.broot02.pojo2graphql.fakes;

public class FakeModel {

    private String id;
    private String model;
    private FakeAccount account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public FakeAccount getAccount() {
        return account;
    }

    public void setAccount(FakeAccount account) {
        this.account = account;
    }
}
