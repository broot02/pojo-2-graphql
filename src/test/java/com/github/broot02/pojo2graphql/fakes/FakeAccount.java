package com.github.broot02.pojo2graphql.fakes;

public class FakeAccount {

    private String id;
    private String name;
    private int sequence;
    private FakeUser user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public FakeUser getUser() {
        return user;
    }

    public void setUser(FakeUser user) {
        this.user = user;
    }
}
