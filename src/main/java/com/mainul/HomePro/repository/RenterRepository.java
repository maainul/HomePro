package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.Renter;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {

    List<Renter> findByUser(UserEntity user);

}
