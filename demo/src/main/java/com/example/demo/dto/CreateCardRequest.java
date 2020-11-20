package com.example.demo.dto;

import java.util.Date;

public class CreateCardRequest {

    private String cardNumber;
    private String type;
    private Long balance;
    private Date validFrom;
    private Date validTo;
    private String status;
    private String visiblePan;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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


}
