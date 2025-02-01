package step.cryptobot.model.binance.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SorOrderRequestDto {
    private String symbol;
    private String side;
    private String type;
    private String timeInForce;
    private BigDecimal quantity;
    private BigDecimal price;
    private String newClientOrderId;
    private Long strategyId;
    private Integer strategyType;
    private BigDecimal icebergQty;
    private String newOrderRespType;
    private String selfTradePreventionMode;
    private Long recvWindow;
    private Long timestamp;
}
