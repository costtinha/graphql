package com.project.graphql.persistance;

import com.project.graphql.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("profissaoJpaRepository")
public interface ProfessionRepository extends JpaRepository<Profession,Integer> {
    Profession findProfessionByProfessionName(String profName);
}
