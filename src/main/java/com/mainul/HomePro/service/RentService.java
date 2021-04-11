package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.springSecurity.entity.UserEntity;

import java.util.Date;
import java.util.List;

public interface RentService {

    public void saveRent(Rent rent, UserEntity user);

    public List<Rent> getAllRent(UserEntity user);

    void deleteRentById(Long id);

    public Rent getRentById(Long id);

    int totalRent(UserEntity user);

    int totalElectricityBill(UserEntity user);

    List<Rent> getAllDataByMonth(Date randomDate, UserEntity user);

    int countMonthWiseRentAmount(UserEntity user);

    int countCurrentYearRent(UserEntity user);

    List<Rent> currentMonthRentList(UserEntity user);

    List<Rent> currentYearRentList(UserEntity user);

}
