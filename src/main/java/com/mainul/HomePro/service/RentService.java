package com.mainul.HomePro.service;

import com.mainul.HomePro.models.Rent;

import java.util.Date;
import java.util.List;

public interface RentService {

    public void saveRent(Rent rent);

    public List<Rent> getAllRent();

    public Rent getRentById(Long id);

    int totalRent();

    int totalElectricityBill();

    List<Rent> getAllDataByMonth(Date randomDate);

    int countMonthWiseRentAmount();

    int countCurrentYearRent();

    List<Rent> currentMonthRentList();

}
