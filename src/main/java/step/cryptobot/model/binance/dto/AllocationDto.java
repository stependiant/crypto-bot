package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class AllocationDto {
    private String symbol;
    private int allocationId;
    private String allocationType;
    private long orderId;
    private long orderListId;
    private String price;
    private String qty;
    private String quoteQty;
    private String commission;
    private String commissionAsset;
    private long time;
    private boolean isBuyer;
    private boolean isMaker;
    private boolean isAllocator;
}
