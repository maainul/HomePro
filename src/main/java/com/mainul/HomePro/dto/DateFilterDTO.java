package com.mainul.HomePro.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DateFilterDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date targetDate;

    public DateFilterDTO() {

    }

    public DateFilterDTO(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "DateFilterDTO{" +
                "targetDate=" + targetDate +
                '}';
    }
}
