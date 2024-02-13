package com.app.repo;

import com.app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    //Custom Query to get user by name along with role
    @Query("select u from UserEntity u join fetch u.role where u.email=?1")
    Optional<UserEntity> findByEmail(String email);
}
