package step.cryptobot.model.binance.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FillDto {
    private BigDecimal price;
    private BigDecimal qty;
    private BigDecimal commission;
    private String commissionAsset;
    private Long tradeId;
}
