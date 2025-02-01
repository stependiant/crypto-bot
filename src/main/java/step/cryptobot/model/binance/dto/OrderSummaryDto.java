package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class OrderSummaryDto {
    private String symbol;
    private Long orderId;
    private String clientOrderId;
}
