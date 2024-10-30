package com.varkovcih.lesson_8.task_1.model.card;

import java.util.Date;

public class VisaCard extends BaseCard {

    private int cashback;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount, int cashback) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.cashback = cashback;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }
}
