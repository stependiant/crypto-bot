package step.cryptobot.model.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AggTradeDto {
    @JsonProperty("a")
    private long aggregateTradeId;
    @JsonProperty("p")
    private String price;
    @JsonProperty("q")
    private String quantity;
    @JsonProperty("f")
    private long firstTradeId;
    @JsonProperty("l")
    private long lastTradeId;
    @JsonProperty("T")
    private long timestamp;
    @JsonProperty("m")
    private boolean isBuyerMaker;
    @JsonProperty("M")
    private boolean isBestMatch;
}
