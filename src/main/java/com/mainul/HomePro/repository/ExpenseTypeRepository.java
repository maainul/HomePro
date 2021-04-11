package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.ExpenseType;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {

    List<ExpenseType> findByUser(UserEntity user);
}
