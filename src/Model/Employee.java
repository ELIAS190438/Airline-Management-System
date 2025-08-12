/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

public class Employee {

    private Integer employeeId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String jobTitle;
    private String department;
    private String username;
    private String passwordHash;
    private LocalDate hireDate;
    private String active;

    public Employee() {
        this.employeeId = null;
        this.fullName = null;
        this.dateOfBirth = null;
        this.gender = null;
        this.email = null;
        this.phone = null;
        this.jobTitle = null;
        this.department = null;
        this.username = null;
        this.passwordHash = null;
        this.hireDate = null;
        this.active = null;
    }

    public Employee(
            Integer employeeId,
            String fullName,
            LocalDate dateOfBirth,
            String gender,
            String email,
            String phone,
            String jobTitle,
            String department,
            String username,
            String passwordHash,
            LocalDate hireDate,
            String active) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.department = department;
        this.username = username;
        this.passwordHash = passwordHash;
        this.hireDate = hireDate;
        this.active = active;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", jobTitle=" + jobTitle + ", department=" + department + ", username=" + username + ", passwordHash=" + passwordHash + ", hireDate=" + hireDate + ", active=" + active + '}';
    }

}
