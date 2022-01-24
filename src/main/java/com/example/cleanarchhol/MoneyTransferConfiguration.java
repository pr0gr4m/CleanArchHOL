package com.example.cleanarchhol;

import com.example.cleanarchhol.account.application.service.MoneyTransferProperties;
import com.example.cleanarchhol.account.domain.Money;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MoneyTransferConfigurationProperties.class)
public class MoneyTransferConfiguration {
    @Bean
    public MoneyTransferProperties moneyTransferProperties(MoneyTransferConfigurationProperties moneyTransferConfigurationProperties){
        return new MoneyTransferProperties(Money.of(moneyTransferConfigurationProperties.getTransferThreshold()));
    }
}
