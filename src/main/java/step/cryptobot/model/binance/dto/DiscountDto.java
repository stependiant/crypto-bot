package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class DiscountDto {
    private Boolean enabledForAccount;
    private Boolean enabledForSymbol;
    private String discountAsset;
    private String discount;
}
