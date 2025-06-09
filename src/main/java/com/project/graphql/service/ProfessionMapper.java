package com.project.graphql.service;

import com.project.graphql.dtos.CreateProfessionInput;
import com.project.graphql.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ProfessionMapper {
    public Profession professionDtoToProfession(CreateProfessionInput input){
        Profession profession = new Profession();
        profession.setProfName(input.profName());
        profession.setUsers(Collections.emptyList());
        return profession;
    }
}
