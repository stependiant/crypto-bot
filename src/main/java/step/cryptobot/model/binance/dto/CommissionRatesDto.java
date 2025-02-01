package step.cryptobot.model.binance.dto;

import lombok.Data;

@Data
public class CommissionRatesDto {
    private String symbol;
    private StandardCommission standardCommission;
    private TaxCommission taxCommission;
    private Discount discount;

    @Data
    public static class StandardCommission {
        private String maker;
        private String taker;
        private String buyer;
        private String seller;
    }

    @Data
    public static class TaxCommission {
        private String maker;
        private String taker;
        private String buyer;
        private String seller;
    }

    @Data
    public static class Discount {
        private boolean enabledForAccount;
        private boolean enabledForSymbol;
        private String discountAsset;
        private String discount;
    }
}
