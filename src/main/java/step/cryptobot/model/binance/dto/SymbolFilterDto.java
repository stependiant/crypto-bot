package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class SymbolFilterDto {
    private String filterType;

    private String minPrice;
    private String maxPrice;
    private String tickSize;

    private String minQty;
    private String maxQty;
    private String stepSize;

    private Integer limit;

    private Integer minTrailingAboveDelta;
    private Integer maxTrailingAboveDelta;
    private Integer minTrailingBelowDelta;
    private Integer maxTrailingBelowDelta;

    private String bidMultiplierUp;
    private String bidMultiplierDown;
    private String askMultiplierUp;
    private String askMultiplierDown;
    private Integer avgPriceMins;

    private String minNotional;
    private Boolean applyMinToMarket;
    private String maxNotional;
    private Boolean applyMaxToMarket;

    private Integer maxNumOrders;

    private Integer maxNumAlgoOrders;
}
