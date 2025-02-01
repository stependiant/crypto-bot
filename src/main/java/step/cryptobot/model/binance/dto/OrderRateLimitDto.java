package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class OrderRateLimitDto {
    private String rateLimitType;
    private String interval;
    private int intervalNum;
    private int limit;
    private int count;
}
