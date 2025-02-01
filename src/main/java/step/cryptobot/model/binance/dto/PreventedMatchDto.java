package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class PreventedMatchDto {
    private String symbol;
    private long preventedMatchId;
    private long takerOrderId;
    private String makerSymbol;
    private long makerOrderId;
    private long tradeGroupId;
    private String selfTradePreventionMode;
    private String price;
    private String makerPreventedQuantity;
    private long transactTime;
}
