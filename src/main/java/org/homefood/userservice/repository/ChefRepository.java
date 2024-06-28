package org.homefood.userservice.repository;

import org.homefood.userservice.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChefRepository extends JpaRepository<Chef, Long> {

    @Query(nativeQuery = true, value = "SELECT * from chef as c WHERE c.user_id = :userId")
    Chef findByUserId(@Param("userId") Long userId);


}
