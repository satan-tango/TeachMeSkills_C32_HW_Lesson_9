package com.varkovcih.lesson_8.task_1.validator;

import com.varkovcih.lesson_8.task_1.model.card.BaseCard;
import com.varkovcih.lesson_8.task_1.model.card.MasterCard;
import com.varkovcih.lesson_8.task_1.transfer.CardTransferService;
import com.varkovcih.lesson_8.task_1.transfer.impl.MasterCardTransferService;
import com.varkovcih.lesson_8.task_1.transfer.impl.VisaCardTransferService;
import com.varkovcih.lesson_8.task_1.utils.TransferState;

public class ServiceValidator {

    public static TransferState isServiceMatchCard(BaseCard card, CardTransferService service) {
        if (card instanceof MasterCard) {
            return (service instanceof MasterCardTransferService) ?
                    TransferState.READY_FOR_TRANSFER : TransferState.FAILED_CARD_ISNT_MATCH_SERVICE;

        } else {
            return (service instanceof VisaCardTransferService)
                    ? TransferState.READY_FOR_TRANSFER : TransferState.FAILED_CARD_ISNT_MATCH_SERVICE;
        }
    }
}
