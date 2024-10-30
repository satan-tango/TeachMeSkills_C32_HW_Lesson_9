package com.varkovcih.lesson_8.task_1.model.document;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран
public class Check {

    private double transferAmount;
    private Date transferDate;
    private String sourceFrom;
    private String sourceTo;
    private String commentary;

    public Check(double transferAmount, Date transferdate, String sourceFrom, String sourceTo, String commentary) {
        this.transferAmount = transferAmount;
        this.transferDate = transferdate;
        this.sourceFrom = sourceFrom;
        this.sourceTo = sourceTo;
        this.commentary = commentary;
    }



    public void showInformationAboutCheck() {
        System.out.printf("Check\nDate: %tD %tT\nSender:%s\nRecipient:%s\nCommentary: %s\n---------------\nAmount: %.2f",
                transferDate, transferDate, getEncryptedSenderInformation(sourceFrom),
                getEncryptedSenderInformation(sourceTo), commentary, transferAmount);
    }

    private String getEncryptedSenderInformation(String line) {
        String[] array = line.split("");

        for (int i = 0; i < array.length; i++) {
            if (i == 0 || i == 1 || i == array.length - 1 || i == array.length - 2) {
                continue;
            }
            array[i] = "*";
        }

        return Arrays.stream(array)
                .collect(Collectors.joining());
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Date getTransferdate() {
        return transferDate;
    }

    public void setTransferDate(Date transferdate) {
        this.transferDate = transferdate;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    public String getSourceTo() {
        return sourceTo;
    }

    public void setSourceTo(String sourceTo) {
        this.sourceTo = sourceTo;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}
