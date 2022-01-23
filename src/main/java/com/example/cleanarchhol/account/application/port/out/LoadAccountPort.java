package com.example.cleanarchhol.account.application.port.out;

import com.example.cleanarchhol.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
