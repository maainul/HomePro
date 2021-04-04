package com.mainul.HomePro.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeConverter {

    public static LocalDateTime dateToLocalDateTimeConverter(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date localDateTimeToDateConverter(LocalDateTime localDateTime) {
        return java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    // Date to long converter
    // 12/10/2020 to 143934023
    public static Long dateToLong(LocalDateTime localDateTime) {
        String pattern = "yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String myDate = localDateTime.format(formatter);
        return LocalDateTime.parse(myDate, formatter).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // long to date Converter
    //  143934023 to 12/10/2020
    public static LocalDateTime longToDateTime(long longDate) {
        return Instant.ofEpochMilli(longDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
