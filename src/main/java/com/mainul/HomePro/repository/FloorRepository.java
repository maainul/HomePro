package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.Floor;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Long> {
    List<Floor> findByUser(UserEntity user);


}
