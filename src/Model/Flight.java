package Model;

import java.time.LocalTime;
import java.time.LocalDate;

public class Flight {

    private Integer flightId;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private LocalTime departureOnlyTime;
    private LocalTime arrivalOnlyTime;
    private FlightStatus flightStatus;
    private String aircraftModel;
    private Integer availableSeats;
    private Integer reservations;

    public enum FlightStatus {
        SCHEDULED,
        DELAYED,
        CANCELLED,
        COMPLETED
    }

    public Flight() {
        this.flightId = null;
        this.flightNumber = null;
        this.origin = null;
        this.destination = null;
        this.flightDate = null;
        this.departureOnlyTime = null;
        this.arrivalOnlyTime = null;
        this.flightStatus = null;
        this.aircraftModel = null;
        this.availableSeats = null;
        this.reservations = null;
    }

    public Flight(
            Integer flightId,
            String flightNumber,
            String origin,
            String destination,
            LocalDate flightDate,
            LocalTime departureOnlyTime,
            LocalTime arrivalOnlyTime,
            FlightStatus flightStatus,
            String aircraftModel,
            Integer availableSeats,
            Integer reservations) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.departureOnlyTime = departureOnlyTime;
        this.arrivalOnlyTime = arrivalOnlyTime;
        this.flightStatus = flightStatus;
        this.aircraftModel = aircraftModel;
        this.availableSeats = availableSeats;
        this.reservations = reservations;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getDepartureOnlyTime() {
        return departureOnlyTime;
    }

    public void setDepartureOnlyTime(LocalTime departureOnlyTime) {
        this.departureOnlyTime = departureOnlyTime;
    }

    public LocalTime getArrivalOnlyTime() {
        return arrivalOnlyTime;
    }

    public void setArrivalOnlyTime(LocalTime arrivalOnlyTime) {
        this.arrivalOnlyTime = arrivalOnlyTime;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getReservations() {
        return reservations;
    }

    public void setReservations(Integer reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightId=" + flightId + ", flightNumber=" + flightNumber + ", origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + ", departureOnlyTime=" + departureOnlyTime + ", arrivalOnlyTime=" + arrivalOnlyTime + ", flightStatus=" + flightStatus + ", aircraftModel=" + aircraftModel + ", availableSeats=" + availableSeats + ", reservations=" + reservations + '}';
    }

}
