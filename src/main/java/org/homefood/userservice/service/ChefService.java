package org.homefood.userservice.service;

import org.homefood.userservice.model.Chef;
import org.homefood.userservice.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

    private final ChefRepository chefRepository;

    public ChefService(@Autowired ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    public Chef getChef(Long id) {
        return chefRepository.findByUserId(id);
    }

    public Chef saveChef(Chef chef) {
        return chefRepository.save(chef);
    }

}
