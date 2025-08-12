/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a flight reservation record.
 */
public class Reservation {

    private Integer reservationId;
    private String passengerName;
    private String classType;
    private String fromLocation;    // maps to DB column `from`
    private String toLocation;      // maps to DB column `To`
    private String flightNumber;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer baggageWeight;

    // No-arg constructor
    public Reservation() {
        this.reservationId = null;
        this.passengerName = null;
        this.classType = null;
        this.fromLocation = null;
        this.toLocation = null;
        this.flightNumber = null;
        this.flightDate = null;
        this.departureTime = null;
        this.arrivalTime = null;
        this.baggageWeight = null;
    }

    // All-args constructor
    public Reservation(
            Integer reservationId,
            String passengerName,
            String classType,
            String fromLocation,
            String toLocation,
            String flightNumber,
            LocalDate flightDate,
            LocalTime departureTime,
            LocalTime arrivalTime,
            Integer baggageWeight
    ) {
        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.classType = classType;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.baggageWeight = baggageWeight;
    }

    // Getters & setters
    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(Integer baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationId=" + reservationId + ", passengerName=" + passengerName + ", classType=" + classType + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", baggageWeight=" + baggageWeight + '}';
    }
    
}
