package com.project.graphql.service;

import com.project.graphql.dtos.CreateProfessionInput;
import com.project.graphql.entity.Profession;
import com.project.graphql.errors.NotFoundException;
import com.project.graphql.persistance.ProfessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String deleteProfession(Integer profId) {
        if(!professionRepository.existsById(profId)){
            throw new RuntimeException("A profissão id: "+profId+" não existe no banco de dados");
        }
        professionRepository.deleteById(profId);
        return "Profissão deletada com sucesso";

    }

    public List<Profession> professions() {
        return professionRepository.findAllWithUsers();
    }

    public Profession findProfessionById(Integer profId) {
        return professionRepository.findById(profId)
                .orElseThrow(() -> new NotFoundException("Profissão não encontrada"));
    }
}
