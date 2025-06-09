package com.project.graphql.controller;

import com.project.graphql.dtos.CreateUserInput;
import com.project.graphql.entity.Profession;
import com.project.graphql.entity.User;
import com.project.graphql.service.UserService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @QueryMapping
    public List<User> users(DataFetchingEnvironment env){
        var fieldNames = env.getSelectionSet().getFields().stream()
                .map(f -> f.getName())
                .collect(Collectors.toSet());
        Boolean basicOnly = fieldNames.contains("firstName") &&
                fieldNames.contains("age") &&
                fieldNames.size() == 2;
        if(basicOnly){
            return service.findAllUsersModuleBasic();
        } else {
            return service.findAllUsersModuleProfession();
        }

    }

    @QueryMapping
    public User userById(@Argument Integer userId){
        return service.findUserById(userId);
    }

    @MutationMapping
    public User createUser(@Argument("input") CreateUserInput input){
       return service.save(input);

    }

    @MutationMapping
    public String deleteUser(@Argument("userId") Integer userId){
        return service.deleteUserById(userId);
    }

    @SchemaMapping(typeName = "Profession", field = "users")
    public List<User> resolveUser(Profession profession){
        return service.findUserByProfId(profession.getProfId());
    }
}
