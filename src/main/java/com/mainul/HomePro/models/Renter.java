
package com.mainul.HomePro.models;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String maritalStatus;
    private String NID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String email;
    private String phoneNumber1;
    private String phoneNumber2;
    private String facebook;
    private String occupation;
    private String permanentAddress;
    private String officeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date officeJoinDate;
    private String post;
    private String salary;
    //private Room room;
    private String discount;
    private String advanceMonth;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rentalDate;
    private String renterImage;

    public Renter() {
    }

    public Renter(long id, String firstName, String lastName, String middleName, String gender, String maritalStatus, String NID, Date dateOfBirth, String email, String phoneNumber1, String phoneNumber2, String facebook, String occupation, String permanentAddress, String officeName, Date officeJoinDate, String post, String salary, String discount, String advanceMonth, Date rentalDate, String renterImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.NID = NID;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.facebook = facebook;
        this.occupation = occupation;
        this.permanentAddress = permanentAddress;
        this.officeName = officeName;
        this.officeJoinDate = officeJoinDate;
        this.post = post;
        this.salary = salary;
        this.discount = discount;
        this.advanceMonth = advanceMonth;
        this.rentalDate = rentalDate;
        this.renterImage = renterImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Date getOfficeJoinDate() {
        return officeJoinDate;
    }

    public void setOfficeJoinDate(Date officeJoinDate) {
        this.officeJoinDate = officeJoinDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getAdvanceMonth() {
        return advanceMonth;
    }

    public void setAdvanceMonth(String advanceMonth) {
        this.advanceMonth = advanceMonth;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getRenterImage() {
        return renterImage;
    }

    public void setRenterImage(String renterImage) {
        this.renterImage = renterImage;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", NID='" + NID + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", facebook='" + facebook + '\'' +
                ", occupation='" + occupation + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", officeName='" + officeName + '\'' +
                ", officeJoinDate=" + officeJoinDate +
                ", post='" + post + '\'' +
                ", salary='" + salary + '\'' +
                ", discount='" + discount + '\'' +
                ", advanceMonth='" + advanceMonth + '\'' +
                ", rentalDate=" + rentalDate +
                ", renterImage='" + renterImage + '\'' +
                '}';
    }
}


