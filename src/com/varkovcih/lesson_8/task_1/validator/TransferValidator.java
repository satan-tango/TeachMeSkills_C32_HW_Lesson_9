package com.varkovcih.lesson_8.task_1.validator;

import com.varkovcih.lesson_8.task_1.model.card.BaseCard;
import com.varkovcih.lesson_8.task_1.utils.TransferState;

public class TransferValidator {

    public static TransferState validateTransferAmount(BaseCard card, double transferAmount, double limit) {
        if (transferAmount > card.getAmount()) return TransferState.FAILED_NOT_ENOUGH_MONEY;

        if (transferAmount == 0) return TransferState.FAILED_ZERO;

        if (transferAmount < 0) return TransferState.FAILED_LESS_THAN_ZERO;

        if (transferAmount > limit) return TransferState.FAILED_ABOVE_LIMIT;

        return TransferState.READY_FOR_TRANSFER;
    }
}
