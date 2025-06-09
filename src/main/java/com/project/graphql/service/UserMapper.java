package com.project.graphql.service;

import com.project.graphql.entity.Profession;
import com.project.graphql.entity.User;
import com.project.graphql.entity.UserCache;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserCache userToCache(User user){
        return new UserCache(user.getUserId(),user.getFirstName(),user.getLastName(), user.getAge(), user.getProfId().getProfId());
    }
    public User cacheToUser(UserCache cache){
        Profession profession = new Profession();
        profession.setProfId(cache.getProfId());
        return new User(cache.getUserId(), cache.getFirstName(), cache.getLastName(), cache.getAge(), profession);
    }
}
