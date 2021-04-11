package com.mainul.HomePro.repository;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    List<Rent> findRentsByRentMonthBetween(Date rentMonth, Date rentalPaymentDate2);
    List<Rent> findByUser(UserEntity user);
    List<Rent> findRentsByRentMonthBetweenAndUser(Date rentMonth, Date rentalPaymentDate2, UserEntity user);


}
