package com.project.graphql.service;

import com.project.graphql.dtos.CreateProfessionInput;
import com.project.graphql.entity.Profession;
import com.project.graphql.persistance.ProfessionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService {
    private final ProfessionRepository professionRepository;
    private final ProfessionMapper mapper;

    public ProfessionService(ProfessionRepository professionRepository, ProfessionMapper mapper) {
        this.professionRepository = professionRepository;
        this.mapper = mapper;
    }

    public Profession save(CreateProfessionInput input) {
        return professionRepository.save(mapper.professionDtoToProfession(input));
    }
}
