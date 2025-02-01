package step.cryptobot.model.binance.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SorOrderResponseDto {
    private String symbol;
    private Long orderId;
    private Long orderListId;
    private String clientOrderId;
    private Long transactTime;
    private BigDecimal price;
    private BigDecimal origQty;
    private BigDecimal executedQty;
    private BigDecimal origQuoteOrderQty;
    private BigDecimal cummulativeQuoteQty;
    private String status;
    private String timeInForce;
    private String type;
    private String side;
    private Long workingTime;
    private List<SorFillDto> fills;
    private String workingFloor;
    private String selfTradePreventionMode;
    private Boolean usedSor;
}
