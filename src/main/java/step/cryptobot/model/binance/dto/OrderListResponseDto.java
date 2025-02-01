package step.cryptobot.model.binance.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderListResponseDto {
    private Long orderListId;
    private String contingencyType;
    private String listStatusType;
    private String listOrderStatus;
    private String listClientOrderId;
    private Long transactionTime;
    private String symbol;
    private List<OrderSummaryDto> orders;
    private List<OrderResponseDto> orderReports;
}
