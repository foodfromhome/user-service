package org.homefood.userservice.controller;

import org.homefood.userservice.controller.dto.NewUserRequest;
import org.homefood.userservice.model.Users;
import org.homefood.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Users getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public Users postUser(@RequestBody NewUserRequest request) {
        return userService.saveUser(request);
    }




}
