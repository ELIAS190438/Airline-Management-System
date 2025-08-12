package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AirCraft {
    private Integer aircraftID;
    private String registration;
    private String manufacture;
    private String model;
    private Integer seatCapacity;
    private String currentStatus;
    private OwnershipType ownershipType;
    private LocalDate leaseExpiry;
    private BigDecimal purchasePrice;
    private BigDecimal monthlyLease;
    private Integer firstClassSeats;
    private Integer businessSeats;
    private Integer economySeats;
    private String engineType;
    private Integer engineCount;
    private Integer fuelCapacity;

    public enum OwnershipType {
        OWNED,
        LEASED
    }

    // Default constructor
    public AirCraft() {
        this.aircraftID = null;
        this.registration = null;
        this.manufacture = null;
        this.model = null;
        this.seatCapacity = null;
        this.currentStatus = null;
        this.ownershipType = null;
        this.leaseExpiry = null;
        this.purchasePrice = null;
        this.monthlyLease = null;
        this.firstClassSeats = null;
        this.businessSeats = null;
        this.economySeats = null;
        this.engineType = null;
        this.engineCount = null;
        this.fuelCapacity = null;
    }

    public Integer getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(Integer aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(OwnershipType ownershipType) {
        this.ownershipType = ownershipType;
    }

    public LocalDate getLeaseExpiry() {
        return leaseExpiry;
    }

    public void setLeaseExpiry(LocalDate leaseExpiry) {
        this.leaseExpiry = leaseExpiry;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getMonthlyLease() {
        return monthlyLease;
    }

    public void setMonthlyLease(BigDecimal monthlyLease) {
        this.monthlyLease = monthlyLease;
    }

    public Integer getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(Integer firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }

    public Integer getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        this.businessSeats = businessSeats;
    }

    public Integer getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(Integer economySeats) {
        this.economySeats = economySeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getEngineCount() {
        return engineCount;
    }

    public void setEngineCount(Integer engineCount) {
        this.engineCount = engineCount;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return "AirCraft{" + "aircraftID=" + aircraftID + ", registration=" + registration + ", manufacture=" + manufacture + ", model=" + model + ", seatCapacity=" + seatCapacity + ", currentStatus=" + currentStatus + ", ownershipType=" + ownershipType + ", leaseExpiry=" + leaseExpiry + ", purchasePrice=" + purchasePrice + ", monthlyLease=" + monthlyLease + ", firstClassSeats=" + firstClassSeats + ", businessSeats=" + businessSeats + ", economySeats=" + economySeats + ", engineType=" + engineType + ", engineCount=" + engineCount + ", fuelCapacity=" + fuelCapacity + '}';
    }
    
}