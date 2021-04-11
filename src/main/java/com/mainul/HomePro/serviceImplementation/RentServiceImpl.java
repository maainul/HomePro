package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.repository.RentRepository;
import com.mainul.HomePro.service.RentService;
import com.mainul.HomePro.springSecurity.entity.UserEntity;
import com.mainul.HomePro.springSecurity.service.UserService;
import com.mainul.HomePro.utils.DateTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;


@Service
public class RentServiceImpl implements RentService {

    @Autowired private RentRepository rentRepository;

    @Autowired private UserService userService;

    @Override
    public void saveRent(Rent rent, UserEntity user) {
        rent.getId();
        rent.getRoomRent();
        rent.getRentMonth();
        rent.getArrears();
        rent.getElectricityBill();
        rent.getExtraCharge();
        rent.getInternetBill();
        rent.getPaidArrears();
        rent.getRoomid();
        rent.setUser(user);
        this.rentRepository.save(rent);

    }

    @Override
    public List<Rent> getAllRent(UserEntity user) {
        return rentRepository.findByUser(user);
    }

    @Override
    public void deleteRentById(Long id) {
            rentRepository.deleteById(id);
    }

    @Override
    public Rent getRentById(Long id) {
        Optional<Rent> optional = rentRepository.findById(id);
        Rent rent = null;
        if (optional.isPresent()) {
            rent = optional.get();
        } else {
            throw new RuntimeException("no rent found");
        }
        return rent;
    }

    @Override
    public int totalRent(UserEntity user) {
        List<Rent> rents = rentRepository.findByUser(user);
        int rentTotal = 0;
        for (Rent rent : rents) {
            // System.out.println(rent.getRoomRent());
            rentTotal += rent.getRoomRent();
        }
        return rentTotal;
    }

    @Override
    public int totalElectricityBill(UserEntity user) {
        List<Rent> rents = rentRepository.findByUser(user);
        int totalElectricityBill = 0;
        for (Rent rent : rents) {
            totalElectricityBill += rent.getElectricityBill();
        }
        return totalElectricityBill;
    }

    @Override
    public List<Rent> getAllDataByMonth(Date randomDate, UserEntity user) {
        //convert Date into LocalDateTime
        LocalDateTime localDate = DateTimeConverter.dateToLocalDateTimeConverter(randomDate);
        //peak first day
        LocalDateTime firstDay = localDate.with(firstDayOfMonth());
        // last day of month
        LocalDateTime lastDay = localDate.with(lastDayOfMonth());

        Date f = DateTimeConverter.localDateTimeToDateConverter(firstDay);
        Date s = DateTimeConverter.localDateTimeToDateConverter(lastDay);

        List<Rent> dateList = rentRepository.findRentsByRentMonthBetweenAndUser(f, s,user);

        return dateList;
    }
    @Override
    public int countMonthWiseRentAmount(UserEntity user) {
        Date todayDate = new Date();
        List<Rent> dateList = getAllDataByMonth(todayDate,user);
        int total = 0;
        for (Rent date : dateList) {
            total += date.getRoomRent();
        }
        return total;
    }

    public List<Rent> getYear(Date randomDate, UserEntity user) {
        //List<Rent> dateList = getYear(randomDate);
        LocalDateTime localDateTime = DateTimeConverter.dateToLocalDateTimeConverter(randomDate);
        LocalDateTime fDayOfYear = localDateTime.with(firstDayOfYear());
        LocalDateTime lDatOfyear = localDateTime.with(lastDayOfYear());
        Date f = DateTimeConverter.localDateTimeToDateConverter(fDayOfYear);
        Date l = DateTimeConverter.localDateTimeToDateConverter(lDatOfyear);
        return rentRepository.findRentsByRentMonthBetweenAndUser(f,l,user);
    }

    @Override
    public int countCurrentYearRent(UserEntity user) {
        Date todayDate = new Date();
        List<Rent> dateList = getYear(todayDate,user);
        int total = 0;

        for (Rent rent : dateList) {
            total += rent.getRoomRent();
        }
        return total;
    }

    @Override
    public List<Rent> currentMonthRentList(UserEntity user) {
        Date date = new Date();
        return getAllDataByMonth(date,user);
    }

    @Override
    public List<Rent> currentYearRentList(UserEntity user) {
        Date date = new Date();
        List<Rent> dateList = getYear(date,user);
        return dateList;
    }


}
