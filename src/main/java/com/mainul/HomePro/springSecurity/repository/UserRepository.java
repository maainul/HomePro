package com.mainul.HomePro.springSecurity.repository;


import com.mainul.HomePro.springSecurity.data.user.UserData;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

//  Optional<UserEntity>findByFirstName(String name);

}