package com.hibernateDb.hbdb.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Entity
@Table(name="Payment")
@NamedQueries({
        @NamedQuery(
                name = "getBlueTickInfo",
                query = "select p from Payment p where p.shortName= :shortName"
        ),
        @NamedQuery(
                name = "findAllPayment",
                query = "select p from Payment p"

        )

})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Amount")
    private BigDecimal amount;

    @Column(name="Paid")
    private Boolean paid;

    @Column(name="ShortName")
    private String shortName;

    @Column(name="BlueTick")
    private Boolean blueTick;

    @Column(name="PaymentDate")
    private LocalDateTime date;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Boolean getBlueTick() {
        return blueTick;
    }

    public void setBlueTick(Boolean blueTick) {
        this.blueTick = blueTick;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Payment(BigDecimal amount, Boolean paid, String shortName) {
        this(amount,paid,shortName,true,LocalDateTime.now());

    }

    public Payment(BigDecimal amount, Boolean paid, String shortName, Boolean blueTick) {
        this.amount = amount;
        this.paid = paid;
        this.shortName = shortName;
        this.blueTick = blueTick;
    }

    public Payment(BigDecimal amount, Boolean paid, String shortName, Boolean blueTick, LocalDateTime date) {
        this.amount = amount;
        this.paid = paid;
        this.shortName = shortName;
        this.blueTick = blueTick;
        this.date = date;
    }

    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", paid=" + paid +
                ", shortName='" + shortName + '\'' +
                ", blueTick=" + blueTick +
                ", date=" + date +
                '}';
    }
}
