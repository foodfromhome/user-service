package org.homefood.userservice.controller;


import org.homefood.userservice.model.Chef;
import org.homefood.userservice.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/users/chefs")
public class ChefController {

    private final ChefService chefService;

    public ChefController(@Autowired ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping("/{id}")
    public Chef getChefById(@PathVariable Long id) {
        return chefService.getChef(id);
    }

}
