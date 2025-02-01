package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class TickerPriceDto {
    private String symbol;
    private String price;
}
