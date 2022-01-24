package com.example.cleanarchhol.account.application.service;

import com.example.cleanarchhol.account.application.port.out.AccountLock;
import com.example.cleanarchhol.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(Account.AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        // do nothing
    }

}
