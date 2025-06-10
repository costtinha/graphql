package com.project.graphql.controller;

import com.project.graphql.dtos.CreateProfessionInput;
import com.project.graphql.entity.Profession;
import com.project.graphql.entity.User;
import com.project.graphql.errors.NotFoundException;
import com.project.graphql.persistance.ProfessionRepository;
import com.project.graphql.service.ProfessionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProfessionController {
    private final ProfessionRepository professionRepository;
    private final ProfessionService service;

    public ProfessionController(ProfessionRepository professionRepository, ProfessionService service) {
        this.professionRepository = professionRepository;
        this.service = service;
    }

    @QueryMapping
    public List<Profession> professions(){
        return service.professions();
    }
    @QueryMapping
    public Profession professionById(@Argument("profId") Integer profId){
        return service.findProfessionById(profId);
    }

    @SchemaMapping(typeName = "User", field = "profession")
    public Profession resolveProfession(User user){
        return professionRepository.findById(user.getProfId().getProfId()).orElseThrow(() -> new NotFoundException("Profissão não existe"));
    }

    @MutationMapping
    public Profession createProfession(@Argument("input") CreateProfessionInput input){
        return service.save(input);
    }
    @MutationMapping
    public String deleteProfession(@Argument("profId") Integer profId){
        return service.deleteProfession(profId);
    }

}
