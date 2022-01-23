package com.example.cleanarchhol.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {
    @Getter
    private final AccountId id;

    @Getter
    private final Money baselineBalance;

    @Getter
    private final ActivityWindow activityWindow;

    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id)
        );
    }

    /*
     * 도메인 엔티티 내에서 비즈니스 규칙을 검증
     * 입력 유효성은 입력 모델(input model)에서 검증 -> SendMoneyCommand
     */
    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money))
            return false;
        this.activityWindow.addActivity(new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money
        ));
        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                this.calculateBalance(),
                money.negate())
                .isPositiveOrZero();
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {
        this.activityWindow.addActivity(new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money
        ));
        return true;
    }

    @Value
    public static class AccountId {
        private Long value;
    }
}
