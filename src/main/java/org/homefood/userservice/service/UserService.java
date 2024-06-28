package org.homefood.userservice.service;

import org.homefood.userservice.controller.dto.NewUserRequest;
import org.homefood.userservice.model.Chef;
import org.homefood.userservice.model.PersonRole;
import org.homefood.userservice.model.Users;
import org.homefood.userservice.repository.UserRepository;
import org.homefood.userservice.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ChefService chefService;

    @Autowired
    public UserService(UserRepository userRepository, ChefService chefService) {
        this.userRepository = userRepository;
        this.chefService = chefService;
    }

    public Users getUserByEmail(String email) {
        Users users = userRepository.findByEmail(email);
        if (users == null) {
            throw new UserNotFoundException(email);
        }

        return users;
    }


    public Users saveUser(NewUserRequest request) {
        Users user = Users.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .role(PersonRole
                        .valueOf(request.getRole().toString().toUpperCase()))
                .build();

        user = userRepository.save(user);

        if (request.getRole() == PersonRole.CHEF) {
            Chef chef = new Chef();
            chef.setUserId(user.getId());
            chefService.saveChef(chef);
        }

        return user;
    }

}
