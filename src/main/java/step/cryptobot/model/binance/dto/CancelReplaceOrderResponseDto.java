package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class CancelReplaceOrderResponseDto {
    private String cancelResult;
    private String newOrderResult;
    private OrderCancelResponseDto cancelResponse;
    private OrderResponseDto newOrderResponse;
}
