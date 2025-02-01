package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class MyTradeDto {
    private String symbol;
    private long id;
    private long orderId;
    private long orderListId;
    private String price;
    private String qty;
    private String quoteQty;
    private String commission;
    private String commissionAsset;
    private long time;
    private boolean isBuyer;
    private boolean isMaker;
    private boolean isBestMatch;
}
