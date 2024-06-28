package org.homefood.userservice.repository;

import org.homefood.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
    Users findByUsername(String username);
    Users findByEmailAndPassword(String email, String password);
    Users findByUsernameAndPassword(String username, String password);

}
