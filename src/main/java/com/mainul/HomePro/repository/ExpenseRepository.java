package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseType, Long> {

}
