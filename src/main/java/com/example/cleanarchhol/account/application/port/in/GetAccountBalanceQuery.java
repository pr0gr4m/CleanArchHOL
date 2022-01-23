package com.example.cleanarchhol.account.application.port.in;

import com.example.cleanarchhol.account.domain.Account;
import com.example.cleanarchhol.account.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(Account.AccountId accountId);
}
