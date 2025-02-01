package step.cryptobot.model.binance.dto;

import lombok.Data;

import java.util.List;

@Data
public class SymbolInfoDto {
    private String symbol;
    private String status;
    private String baseAsset;
    private int baseAssetPrecision;
    private String quoteAsset;
    private int quotePrecision;
    private int quoteAssetPrecision;
    private int baseCommissionPrecision;
    private int quoteCommissionPrecision;
    private List<String> orderTypes;
    private boolean icebergAllowed;
    private boolean ocoAllowed;
    private boolean otoAllowed;
    private boolean quoteOrderQtyMarketAllowed;
    private boolean allowTrailingStop;
    private boolean cancelReplaceAllowed;
    private boolean isSpotTradingAllowed;
    private boolean isMarginTradingAllowed;
    private List<SymbolFilterDto> filters;
    private List<String> permissions;
    private List<List<String>> permissionSets;
    private String defaultSelfTradePreventionMode;
    private List<String> allowedSelfTradePreventionModes;
}

