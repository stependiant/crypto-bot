package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class RateLimitDto {
    private String rateLimitType;
    private String interval;
    private int intervalNum;
    private int limit;
}
