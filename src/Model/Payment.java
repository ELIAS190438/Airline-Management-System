
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a payment record.
 */
public class Payment {

    private Integer paymentId;
    private Integer reservationId;
    private String reservationType;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Integer cardNumber;
    private Integer cvv;
    private LocalDate expiryDate;
    private String billingAddress;
    private Boolean isRefunded;

    public enum PaymentMethod {
        CARD,
        CASH,
        ONLINE
    }

    // No-arg constructor
    public Payment() {
        this.paymentId = null;
        this.reservationId = null;
        this.reservationType = null;
        this.paymentDate = null;
        this.amount = null;
        this.paymentMethod = null;
        this.cardNumber = null;
        this.cvv = null;
        this.expiryDate = null;
        this.billingAddress = null;
        this.isRefunded = null;
    }

    // All-args constructor
    public Payment(
            Integer paymentId,
            Integer reservationId,
            String reservationType,
            LocalDateTime paymentDate,
            BigDecimal amount,
            PaymentMethod paymentMethod,
            Integer cardNumber,
            Integer cvv,
            LocalDate expiryDate,
            String billingAddress,
            Boolean isRefunded
    ) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.reservationType = reservationType;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.billingAddress = billingAddress;
        this.isRefunded = isRefunded;
    }

    // Getters & setters
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(Boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", reservationId=" + reservationId + ", reservationType=" + reservationType + ", paymentDate=" + paymentDate + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expiryDate=" + expiryDate + ", billingAddress=" + billingAddress + ", isRefunded=" + isRefunded + '}';
    }
    
}
