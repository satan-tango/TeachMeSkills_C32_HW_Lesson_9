package com.varkovcih.lesson_8.task_1.model.card;


import java.util.Date;

public class MasterCard extends BaseCard {

    private String country;

    public MasterCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount, String country) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
