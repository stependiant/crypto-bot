package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class TestOrderResponseDto {
    private CommissionDto standardCommissionForOrder;
    private CommissionDto taxCommissionForOrder;
    private DiscountDto discount;
}
