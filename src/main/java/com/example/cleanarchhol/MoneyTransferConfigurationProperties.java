package com.example.cleanarchhol;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "money")
public class MoneyTransferConfigurationProperties {
    private long transferThreshold = Long.MAX_VALUE;
}
