package com.project.graphql.persistance;


import com.project.graphql.entity.User;
import com.project.graphql.projection.UserBasicProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userJpaRepository")
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u.firstName AS firstName, u.age AS age FROM User u")
    List<UserBasicProjection> findBasicUsers();

    List<User> findUserByProfId(Integer profId);
    List<User> findAllWithProfession();
}
