package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNo;

    private String type;

    private Long balance;

    private Date validFrom;

    private Date validTo;

    private String status;

    private String visiblePan;

    private Boolean processed;

    public Card(){}

    public Card(String cardNo, String type, Long balance, Date validFrom, Date validTo, String status, String visiblePan, Boolean processed) {
        this.cardNo = cardNo;
        this.type = type;
        this.balance = balance;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.status = status;
        this.visiblePan = visiblePan;
        this.processed = processed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNo;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNo = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVisiblePan() {
        return visiblePan;
    }

    public void setVisiblePan(String visiblePan) {
        this.visiblePan = visiblePan;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNo + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", status='" + status + '\'' +
                ", visiblePan='" + visiblePan + '\'' +
                ", processed='" + processed + '\'' +
                '}';
    }

}
