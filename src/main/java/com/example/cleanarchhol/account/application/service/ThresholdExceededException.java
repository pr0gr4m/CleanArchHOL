package com.example.cleanarchhol.account.application.service;

import com.example.cleanarchhol.account.domain.Money;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ThresholdExceededException extends RuntimeException {
    public ThresholdExceededException(Money threshold, Money actual) {
        super(String.format("Maximum threshold for transferring money exceeded: tried to transfer %s but threshold is %s!", actual, threshold));
    }
}
