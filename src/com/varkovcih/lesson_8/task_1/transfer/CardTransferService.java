package com.varkovcih.lesson_8.task_1.transfer;

import com.varkovcih.lesson_8.task_1.model.account.Account;
import com.varkovcih.lesson_8.task_1.model.card.BaseCard;
import com.varkovcih.lesson_8.task_1.model.document.Check;

public interface CardTransferService {

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document)
    // TODO добавить входные параметры в метод: карта с..., карта на..., сумма трансфера
    Check transferFromCardToCard(BaseCard cardFrom, BaseCard cardTo, double transferAmount);

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document)
    // TODO добавить входные параметры в метод: карта с.., счет на..., сумма трансфера
    Check transferFromCardToAccount(BaseCard card, Account account, double transferAmount);

}
