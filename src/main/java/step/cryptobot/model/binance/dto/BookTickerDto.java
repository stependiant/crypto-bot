package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class BookTickerDto {
    private String symbol;
    private String bidPrice;
    private String bidQty;
    private String askPrice;
    private String askQty;
}
