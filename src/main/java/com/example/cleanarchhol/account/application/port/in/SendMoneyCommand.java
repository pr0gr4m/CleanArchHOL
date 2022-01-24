package com.example.cleanarchhol.account.application.port.in;

import com.example.cleanarchhol.account.domain.Account;
import com.example.cleanarchhol.account.domain.Money;

import com.example.cleanarchhol.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 * 기존 @Getter 시 Controller 테스트 코드 실패
 */
@Value
@EqualsAndHashCode(callSuper = false)
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {
    @NotNull
    private final Account.AccountId sourceAccountId;

    @NotNull
    private final Account.AccountId targetAccountId;

    @NotNull
    private final Money money;

    /*
     * 빌더 패턴 사용 시 인자가 추가되는 경우
     * 빌더 호출자에서 새로운 필드 추가를 잊을 수 있음
     */
    public SendMoneyCommand(
            Account.AccountId sourceAccountId,
            Account.AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}
