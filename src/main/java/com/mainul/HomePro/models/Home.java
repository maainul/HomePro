package com.mainul.HomePro.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String sellerName;
	private String buyerName;
	private String propertySize;
	private String propertyLocation;
	private Date firstPaymentDate;
	private String firstPaymentAmount;
	private Date finalPaymentDate;
	private String propertyPrice;
	private String homeName;
	private String propertyPicture;

}