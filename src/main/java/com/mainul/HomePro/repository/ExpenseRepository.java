package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.Expense;
import com.mainul.HomePro.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
