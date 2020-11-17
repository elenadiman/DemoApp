package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private String card_no;

    private String type;

    private Long balance;

    private Date valid_from;

    private Date valid_to;

    private String status;

    private String visible_pan;

    public Card() {

    }

    public Card(String card_no, String type, Long balance, Date valid_from, Date valid_to, String status, String visible_pan) {
        this.card_no = card_no;
        this.type = type;
        this.balance = balance;
        this.valid_from = valid_from;
        this.valid_to = valid_to;
        this.status = status;
        this.visible_pan = visible_pan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
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

    public Date getValid_from() {
        return valid_from;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public Date getValid_to() {
        return valid_to;
    }

    public void setValid_to(Date valid_to) {
        this.valid_to = valid_to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVisible_pan() {
        return visible_pan;
    }

    public void setVisible_pan(String visible_pan) {
        this.visible_pan = visible_pan;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", card_no='" + card_no + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", valid_from=" + valid_from +
                ", valid_to=" + valid_to +
                ", status='" + status + '\'' +
                ", visible_pan='" + visible_pan + '\'' +
                '}';
    }

}
