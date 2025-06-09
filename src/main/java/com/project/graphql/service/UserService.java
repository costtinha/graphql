package com.project.graphql.service;

import com.project.graphql.cache.UserCacheRepository;
import com.project.graphql.dtos.CreateUserInput;
import com.project.graphql.entity.Profession;
import com.project.graphql.entity.User;
import com.project.graphql.entity.UserCache;
import com.project.graphql.errors.NotFoundException;
import com.project.graphql.persistance.ProfessionRepository;
import com.project.graphql.persistance.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final UserCacheRepository cacheRepository;
    private final ProfessionRepository professionRepository;


    public UserService(UserRepository userRepository, UserMapper mapper,
                       UserCacheRepository cacheRepository, ProfessionRepository professionRepository) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.cacheRepository = cacheRepository;
        this.professionRepository = professionRepository;
    }

    public User findUserById(Integer userId) {
        return userRepository.findById(userId )
                .orElseThrow(() -> new RuntimeException("Usuário com id "+ userId + " não encontrado"));
    }


    public User save(CreateUserInput input) {
        Profession profession = professionRepository.findById(input.getProfId())
                .orElseThrow(() -> new NotFoundException("Profissão não encontrada"));

        User user = new User();
        user.setProfId(profession);
        user.setAge(input.getAge());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user = userRepository.save(user);
        UserCache cache = mapper.userToCache(user);
        cacheRepository.save(cache);
        return user;

    }

    public String deleteUserById(Integer userId) {
        if (!userRepository.existsById(userId)){
            throw new RuntimeException("O usuário com id " + userId + " não existe no banco de dados");
        }
        userRepository.deleteById(userId);
        return "Usuario deletado com sucesso";
    }

    public List<User> findAllUsersModuleBasic() {
        return userRepository.findBasicUsers().stream().map(p-> {
            User user = new User();
            user.setFirstName(p.getFirstName());
            user.setAge(p.getAge());
            return user;
        }).collect(Collectors.toList());
    }

    public List<User> findAllUsersModuleProfession() {
        return userRepository.findAllWithProfession();
    }

    public List<User> findUserByProfId(Integer profId) {
        return userRepository.findUserByProfId(profId);
    }
}
