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
public class Home extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sellerName;
    private String buyerName;
    private String propertySize;
    private String propertyLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstPaymentDate;
    private int firstPaymentAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finalPaymentDate;
    private int propertyPrice;
    private String homeName;
    private String propertyPicture;

    public Home() {

    }

    public Home(long id, String sellerName, String buyerName, String propertySize, String propertyLocation, Date firstPaymentDate, int firstPaymentAmount, Date finalPaymentDate, int propertyPrice, String homeName, String propertyPicture) {
        this.id = id;
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.propertySize = propertySize;
        this.propertyLocation = propertyLocation;
        this.firstPaymentDate = firstPaymentDate;
        this.firstPaymentAmount = firstPaymentAmount;
        this.finalPaymentDate = finalPaymentDate;
        this.propertyPrice = propertyPrice;
        this.homeName = homeName;
        this.propertyPicture = propertyPicture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(String propertySize) {
        this.propertySize = propertySize;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }

    public int getFirstPaymentAmount() {
        return firstPaymentAmount;
    }

    public void setFirstPaymentAmount(int firstPaymentAmount) {
        this.firstPaymentAmount = firstPaymentAmount;
    }

    public Date getFinalPaymentDate() {
        return finalPaymentDate;
    }

    public void setFinalPaymentDate(Date finalPaymentDate) {
        this.finalPaymentDate = finalPaymentDate;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getPropertyPicture() {
        return propertyPicture;
    }

    public void setPropertyPicture(String propertyPicture) {
        this.propertyPicture = propertyPicture;
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", sellerName='" + sellerName + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", propertySize='" + propertySize + '\'' +
                ", propertyLocation='" + propertyLocation + '\'' +
                ", firstPaymentDate=" + firstPaymentDate +
                ", firstPaymentAmount=" + firstPaymentAmount +
                ", finalPaymentDate=" + finalPaymentDate +
                ", propertyPrice=" + propertyPrice +
                ", homeName='" + homeName + '\'' +
                ", propertyPicture='" + propertyPicture + '\'' +
                '}';
    }
    
}