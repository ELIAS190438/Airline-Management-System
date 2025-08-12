package Model;

import java.time.LocalDate;

public class Passenger {

    private Integer passengerId;
    private String fullName;
    private String email;
    private String phone;
    private String passportNumber;
    private String nationality;
    private LocalDate dateOfBirth;
    private String gender;

    // No-arg constructor
    public Passenger() {
        this.passengerId = null;
        this.fullName = null;
        this.email = null;
        this.phone = null;
        this.passportNumber = null;
        this.nationality = null;
        this.dateOfBirth = null;
        this.gender = null;
    }

    // All-args constructor
    public Passenger(Integer passengerId,
            String fullName,
            String email,
            String phone,
            String passportNumber,
            String nationality,
            LocalDate dateOfBirth,
            String gender) {
        this.passengerId = passengerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Getters & Setters
    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passenger{" + "passengerId=" + passengerId + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", passportNumber=" + passportNumber + ", nationality=" + nationality + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }

}
