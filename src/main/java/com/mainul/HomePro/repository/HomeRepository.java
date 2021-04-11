package com.mainul.HomePro.repository;

import javax.persistence.Id;

import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainul.HomePro.models.Home;

import java.util.List;
import java.util.Optional;


@Repository
public interface HomeRepository extends JpaRepository<Home, Id>{


    Optional<Home> findById(long id);

    void deleteById(long id);

    List<Home> findAllByUser(UserEntity user);

    

}
