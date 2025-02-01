package step.cryptobot.output.binance.rest.account.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.AccountInformationDto;
import step.cryptobot.model.binance.dto.AllocationDto;
import step.cryptobot.model.binance.dto.CommissionRatesDto;
import step.cryptobot.model.binance.dto.MyTradeDto;
import step.cryptobot.model.binance.dto.OrderRateLimitDto;
import step.cryptobot.model.binance.dto.PreventedMatchDto;
import step.cryptobot.output.binance.rest.AbstractBinanceClient;
import step.cryptobot.output.binance.rest.account.BinanceAccountDataClient;

import java.util.List;

@Service
public class BinanceAccountDataClientImpl extends AbstractBinanceClient implements BinanceAccountDataClient {

    @Override
    public Mono<AccountInformationDto> getAccountInformation(Boolean omitZeroBalances, Long recvWindow, Long timestamp) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/account")
                            .queryParam("timestamp", timestamp);
                    if (omitZeroBalances != null) {
                        uriBuilder.queryParam("omitZeroBalances", omitZeroBalances);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(AccountInformationDto.class);
    }

    @Override
    public Mono<List<MyTradeDto>> getMyTrades(String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit, Long recvWindow, Long timestamp) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/myTrades")
                            .queryParam("symbol", symbol)
                            .queryParam("timestamp", timestamp);
                    if (orderId != null) {
                        uriBuilder.queryParam("orderId", orderId);
                    }
                    if (startTime != null) {
                        uriBuilder.queryParam("startTime", startTime);
                    }
                    if (endTime != null) {
                        uriBuilder.queryParam("endTime", endTime);
                    }
                    if (fromId != null) {
                        uriBuilder.queryParam("fromId", fromId);
                    }
                    if (limit != null) {
                        uriBuilder.queryParam("limit", limit);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(MyTradeDto.class)
                .collectList();
    }

    @Override
    public Mono<List<OrderRateLimitDto>> getUnfilledOrderCount(Long recvWindow, Long timestamp) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/rateLimit/order")
                            .queryParam("timestamp", timestamp);
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(OrderRateLimitDto.class)
                .collectList();
    }

    @Override
    public Mono<List<PreventedMatchDto>> getMyPreventedMatches(String symbol, Long preventedMatchId, Long orderId, Long fromPreventedMatchId, Integer limit, Long recvWindow, Long timestamp) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/myPreventedMatches")
                            .queryParam("symbol", symbol)
                            .queryParam("timestamp", timestamp);
                    if (preventedMatchId != null) {
                        uriBuilder.queryParam("preventedMatchId", preventedMatchId);
                    }
                    if (orderId != null) {
                        uriBuilder.queryParam("orderId", orderId);
                    }
                    if (fromPreventedMatchId != null) {
                        uriBuilder.queryParam("fromPreventedMatchId", fromPreventedMatchId);
                    }
                    if (limit != null) {
                        uriBuilder.queryParam("limit", limit);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(PreventedMatchDto.class)
                .collectList();
    }

    @Override
    public Mono<List<AllocationDto>> getMyAllocations(String symbol, Long startTime, Long endTime, Integer fromAllocationId, Integer limit, Long orderId, Long recvWindow, Long timestamp) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/myAllocations")
                            .queryParam("symbol", symbol);
                    if (startTime != null) {
                        uriBuilder.queryParam("startTime", startTime);
                    }
                    if (endTime != null) {
                        uriBuilder.queryParam("endTime", endTime);
                    }
                    if (fromAllocationId != null) {
                        uriBuilder.queryParam("fromAllocationId", fromAllocationId);
                    }
                    if (limit != null) {
                        uriBuilder.queryParam("limit", limit);
                    }
                    if (orderId != null) {
                        uriBuilder.queryParam("orderId", orderId);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    if (timestamp != null) {
                        uriBuilder.queryParam("timestamp", timestamp);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(AllocationDto.class)
                .collectList();
    }

    @Override
    public Mono<CommissionRatesDto> getCommissionRates(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/account/commission")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToMono(CommissionRatesDto.class);
    }
}
