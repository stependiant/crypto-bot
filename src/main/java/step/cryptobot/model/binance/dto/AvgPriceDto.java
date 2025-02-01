package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class AvgPriceDto {
    private int mins;
    private String price;
    private long closeTime;
}
