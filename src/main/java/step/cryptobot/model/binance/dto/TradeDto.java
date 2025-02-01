package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class TradeDto {
    private long id;
    private String price;
    private String qty;
    private String quoteQty;
    private long time;
    private boolean isBuyerMaker;
    private boolean isBestMatch;
}
