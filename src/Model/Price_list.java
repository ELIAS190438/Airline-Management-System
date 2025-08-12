package Model;

import java.math.BigDecimal;

/**
 * Represents the pricing details for a flight.
 */
public class Price_list {

    private Integer priceId;
    private String flightNumber;
    private ClassType classType;
    private BigDecimal basePrice;
    private BigDecimal taxesFees;
    private BigDecimal baggageFee;
    private BigDecimal mealFee;
    private BigDecimal seatSelectionFee;
    private BigDecimal total;
    private String currency;

    public enum ClassType {
        ECONOMY,
        BUSINESS,
        FIRST
    }

    // No-arg constructor
    public Price_list() {
        this.priceId = null;
        this.flightNumber = null;
        this.classType = null;
        this.basePrice = null;
        this.taxesFees = null;
        this.baggageFee = null;
        this.mealFee = null;
        this.seatSelectionFee = null;
        this.total = null;
        this.currency = null;
    }

    // All-args constructor
    public Price_list(Integer priceId,
            String flightNumber,
            ClassType classType,
            BigDecimal basePrice,
            BigDecimal taxesFees,
            BigDecimal baggageFee,
            BigDecimal mealFee,
            BigDecimal seatSelectionFee,
            BigDecimal total,
            String currency) {
        this.priceId = priceId;
        this.flightNumber = flightNumber;
        this.classType = classType;
        this.basePrice = basePrice;
        this.taxesFees = taxesFees;
        this.baggageFee = baggageFee;
        this.mealFee = mealFee;
        this.seatSelectionFee = seatSelectionFee;
        this.total = total;
        this.currency = currency;
    }

    // Getters & Setters
    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getTaxesFees() {
        return taxesFees;
    }

    public void setTaxesFees(BigDecimal taxesFees) {
        this.taxesFees = taxesFees;
    }

    public BigDecimal getBaggageFee() {
        return baggageFee;
    }

    public void setBaggageFee(BigDecimal baggageFee) {
        this.baggageFee = baggageFee;
    }

    public BigDecimal getMealFee() {
        return mealFee;
    }

    public void setMealFee(BigDecimal mealFee) {
        this.mealFee = mealFee;
    }

    public BigDecimal getSeatSelectionFee() {
        return seatSelectionFee;
    }

    public void setSeatSelectionFee(BigDecimal seatSelectionFee) {
        this.seatSelectionFee = seatSelectionFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price_list{" + "priceId=" + priceId + ", flightNumber=" + flightNumber + ", classType=" + classType + ", basePrice=" + basePrice + ", taxesFees=" + taxesFees + ", baggageFee=" + baggageFee + ", mealFee=" + mealFee + ", seatSelectionFee=" + seatSelectionFee + ", total=" + total + ", currency=" + currency + '}';
    }

}
