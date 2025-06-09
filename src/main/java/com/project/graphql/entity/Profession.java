package com.project.graphql.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Profession.findProfessionByProfessionName", query = "SELECT p FROM Profession p WHERE p.profName = :profName")
        })
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profId;
    private String profName;

    @OneToMany(mappedBy = "profId")
    @JsonManagedReference
    private List<User> users;

    public Profession(Integer profId, String profName, List<User> users) {
        this.profId = profId;
        this.profName = profName;
        this.users = users;
    }

    public Profession() {
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
