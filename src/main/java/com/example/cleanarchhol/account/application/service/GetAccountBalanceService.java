package com.example.cleanarchhol.account.application.service;

import com.example.cleanarchhol.account.application.port.in.GetAccountBalanceQuery;
import com.example.cleanarchhol.account.application.port.out.LoadAccountPort;
import com.example.cleanarchhol.account.domain.Account;
import com.example.cleanarchhol.account.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {
    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
