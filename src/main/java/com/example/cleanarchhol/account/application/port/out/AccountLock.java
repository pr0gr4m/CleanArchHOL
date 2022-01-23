package com.example.cleanarchhol.account.application.port.out;

import com.example.cleanarchhol.account.domain.Account;

public interface AccountLock {
    void lockAccount(Account.AccountId accountId);
    void releaseAccount(Account.AccountId accountId);
}
