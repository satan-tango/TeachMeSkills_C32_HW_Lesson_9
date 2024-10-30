package com.varkovcih.lesson_8.task_1.utils;

public enum TransferState {
    SUCCESSFUL("Transaction was successful."),
    READY_FOR_TRANSFER("Ready for transfer"),
    FAILED_ZERO("Transaction has failed, you can not enter 0."),
    FAILED_LESS_THAN_ZERO("Transaction has failed, you can not enter negative number."),
    FAILED_ABOVE_LIMIT("Transaction has failed, the amount is above limit."),
    FAILED_NOT_ENOUGH_MONEY("Transaction has failed, not enough money."),
    FAILED_CARD_ISNT_MATCH_SERVICE("Transaction has failed, card is not match service.");

    String commentary;

    TransferState(String commentary) {
        this.commentary = commentary;
    }

    public String getCommentary() {
        return commentary;
    }
}