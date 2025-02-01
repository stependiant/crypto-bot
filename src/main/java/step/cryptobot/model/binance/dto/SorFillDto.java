package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class SorFillDto {
    private String price;
    private String qty;
    private String commission;
    private String commissionAsset;
    private Long tradeId;
}
