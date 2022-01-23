package com.example.cleanarchhol.account.application.port.out;

import com.example.cleanarchhol.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
