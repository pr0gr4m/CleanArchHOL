package com.example.cleanarchhol.account.domain;

import org.junit.jupiter.api.Test;

import static com.example.cleanarchhol.common.AccountTestData.defaultAccount;
import static com.example.cleanarchhol.common.ActivityTestData.defaultActivity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void withdrawalSucceeds() {
        Account.AccountId accountId = new Account.AccountId(1L);
        Account account = defaultAccount()
                .withAccountId(accountId)
                .withBaselineBalance(Money.of(555L))
                .withActivityWindow(new ActivityWindow(
                        defaultActivity()
                                .withTargetAccount(accountId)
                                .withMoney(Money.of(999L)).build(),
                        defaultActivity()
                                .withTargetAccount(accountId)
                                .withMoney(Money.of(1L)).build()
                )).build();
        Money balance = account.calculateBalance();
        assertThat(balance).isEqualTo(Money.of(1555L));
    }
}