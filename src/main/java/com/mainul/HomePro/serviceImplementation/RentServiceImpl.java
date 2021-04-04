package com.mainul.HomePro.serviceImplementation;

import com.mainul.HomePro.models.Rent;
import com.mainul.HomePro.repository.RentRepository;
import com.mainul.HomePro.service.RentService;
import com.mainul.HomePro.utils.DateTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private RentRepository rentRepository;

    @Override
    public void saveRent(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public List<Rent> getAllRent() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getRentById(Long id) {
        Optional<Rent> optional = rentRepository.findById(id);
        Rent rent = null;
        if (optional.isPresent()){
            rent = optional.get();
        }else {
            throw new RuntimeException("no rent found");
        }
        return rent;
    }

    @Override
    public int totalRent() {
        List<Rent> rents = rentRepository.findAll();
        int rentTotal = 0;
        for (Rent rent : rents){
           // System.out.println(rent.getRoomRent());
            rentTotal += rent.getRoomRent();
        }
        return rentTotal;
    }

    @Override
    public int totalElectricityBill() {
        List<Rent> rents = rentRepository.findAll();
        int totalElectricityBill = 0;
        for (Rent rent : rents){
            totalElectricityBill += rent.getElectricityBill();
        }
        return totalElectricityBill;
    }

    @Override
    public List<Rent> getAllDataByMonth(Date randomDate) {
        //convert Date into LocalDateTime
        LocalDateTime localDate = DateTimeConverter.dateToLocalDateTimeConverter(randomDate);
        //peak first day
        LocalDateTime firstDay = localDate.with(firstDayOfMonth());
        // last day of month
        LocalDateTime lastDay = localDate.with(lastDayOfMonth());

        Date f = DateTimeConverter.localDateTimeToDateConverter(firstDay);
        Date s = DateTimeConverter.localDateTimeToDateConverter(lastDay);

        List<Rent> dateList = rentRepository.findRentsByRentalPaymentDateBetween(f,s);

        return dateList;
    }

    @Override
    public int countMonthWiseRentAmount() {
        Date todayDate = new Date();
        List<Rent> dateList = getAllDataByMonth(todayDate);
        int total = 0;
        for(Rent date : dateList){
            total += date.getRoomRent();
        }
        return total;
    }

    @Override
    public int countCurrentYearRent() {
        Date todayDate = new Date();
        LocalDateTime localDateTime = DateTimeConverter.dateToLocalDateTimeConverter(todayDate);
        LocalDateTime fDayOfYear = localDateTime.with(firstDayOfYear());
        LocalDateTime lDatOfyear = localDateTime.with(lastDayOfYear());
        Date f = DateTimeConverter.localDateTimeToDateConverter(fDayOfYear);
        Date l = DateTimeConverter.localDateTimeToDateConverter(lDatOfyear);
        List<Rent> dateList = rentRepository.findRentsByRentalPaymentDateBetween(f,l);
        int total = 0;
        for (Rent rent : dateList){
            total += rent.getRoomRent();
        }
        return total;
    }

}
