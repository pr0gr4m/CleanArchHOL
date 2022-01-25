package com.example.cleanarchhol.account.adapter.in.web;

import com.example.cleanarchhol.account.application.port.in.SendMoneyCommand;
import com.example.cleanarchhol.account.application.port.in.SendMoneyUseCase;
import com.example.cleanarchhol.account.domain.Account;
import com.example.cleanarchhol.account.domain.Money;
import com.example.cleanarchhol.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    boolean sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {
        SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount)
        );
        return sendMoneyUseCase.sendMoney(command);
    }
}
