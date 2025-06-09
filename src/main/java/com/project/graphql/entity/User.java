package com.project.graphql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
@NamedQueries(
        {
                @NamedQuery(name = "User.findUserByProfId", query = "SELECT u FROM User u WHERE u.profId = :profId"),
                @NamedQuery(name = "User.findAllWithProfession", query = "SELECT u FROM User u JOIN FETCH u.profId")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "profId")
    private Profession profId;


    public User(Integer userId, String firstName, String lastName, int age, Profession profId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.profId = profId;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Profession getProfId() {
        return profId;
    }

    public void setProfId(Profession profId) {
        this.profId = profId;
    }
}
