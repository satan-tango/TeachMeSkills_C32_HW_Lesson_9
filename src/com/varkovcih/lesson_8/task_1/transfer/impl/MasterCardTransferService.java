package com.varkovcih.lesson_8.task_1.transfer.impl;

import com.varkovcih.lesson_8.task_1.model.account.Account;
import com.varkovcih.lesson_8.task_1.model.card.BaseCard;
import com.varkovcih.lesson_8.task_1.model.document.Check;
import com.varkovcih.lesson_8.task_1.validator.ServiceValidator;
import com.varkovcih.lesson_8.task_1.validator.TransferValidator;
import com.varkovcih.lesson_8.task_1.transfer.CardTransferService;
import com.varkovcih.lesson_8.task_1.utils.Constants;
import com.varkovcih.lesson_8.task_1.utils.TransferState;

import java.util.Date;

// TODO реализовать имплементацию интерфейса
public class MasterCardTransferService implements CardTransferService {
    @Override
    public Check transferFromCardToCard(BaseCard cardFrom, BaseCard cardTo, double transferAmount) {
        if (ServiceValidator.isServiceMatchCard(cardFrom, new MasterCardTransferService())
                == TransferState.FAILED_CARD_ISNT_MATCH_SERVICE) {
            return new Check(transferAmount, new Date(),
                    cardFrom.getCardNumber(), cardTo.getCardNumber(), TransferState.FAILED_CARD_ISNT_MATCH_SERVICE.getCommentary());
        }

        TransferState state = TransferValidator
                .validateTransferAmount(cardFrom, transferAmount, Constants.MASTER_CARD_TRANSFER_LIMIT);

        if (state != TransferState.READY_FOR_TRANSFER) {
            return new Check(transferAmount, new Date(),
                    cardFrom.getCardNumber(), cardTo.getCardNumber(), state.getCommentary());
        }

        cardFrom.setAmount(cardFrom.getAmount() - transferAmount);
        cardTo.setAmount(cardTo.getAmount() - transferAmount);

        return new Check(transferAmount, new Date(),
                cardFrom.getCardNumber(), cardTo.getCardNumber(), TransferState.SUCCESSFUL.getCommentary());
    }

    @Override
    public Check transferFromCardToAccount(BaseCard card, Account account, double transferAmount) {
        if (ServiceValidator.isServiceMatchCard(card, new MasterCardTransferService())
                == TransferState.FAILED_CARD_ISNT_MATCH_SERVICE) {
            return new Check(transferAmount, new Date(),
                    card.getCardNumber(), account.getAccountNumber(), TransferState.FAILED_CARD_ISNT_MATCH_SERVICE.getCommentary());
        }

        TransferState state = TransferValidator
                .validateTransferAmount(card, transferAmount, Constants.MASTER_CARD_TRANSFER_LIMIT);

        if (state != TransferState.READY_FOR_TRANSFER) {
            return new Check(transferAmount, new Date(),
                    card.getCardNumber(), account.getAccountNumber(), state.getCommentary());
        }

        card.setAmount(card.getAmount() - transferAmount);
        account.setAmount(account.getAmount() + transferAmount);

        return new Check(transferAmount, new Date(),
                card.getCardNumber(), account.getAccountNumber(), TransferState.SUCCESSFUL.getCommentary());
    }

}
