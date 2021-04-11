package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.models.Room;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByUser(UserEntity user);

}
