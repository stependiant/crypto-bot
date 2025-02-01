package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class TickerDto {
    private String symbol;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String lastPrice;
    private String volume;
    private String quoteVolume;
    private long openTime;
    private long closeTime;
    private long firstId;
    private long lastId;
    private long count;
}
