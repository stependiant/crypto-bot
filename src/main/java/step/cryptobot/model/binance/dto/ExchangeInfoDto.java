package step.cryptobot.model.binance.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeInfoDto {
    private String timezone;
    private long serverTime;
    private List<RateLimitDto> rateLimits;
    private List<ExchangeFilterDto> exchangeFilters;
    private List<SymbolInfoDto> symbols;
}
