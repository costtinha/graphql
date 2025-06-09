package com.project.graphql.dtos;

public class CreateUserInput {
    private String firstName;
    private String lastName;
    private int age;
    private int profId;

    public CreateUserInput(String firstName, String lastName, int age, int profId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.profId = profId;
    }

    public CreateUserInput() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }
}
