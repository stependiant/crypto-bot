package step.cryptobot.model.binance.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderBookDto {
    private long lastUpdateId;
    private List<PriceLevelDto> bids;
    private List<PriceLevelDto> asks;
}
