package step.cryptobot.output.binance.rest.market.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.AggTradeDto;
import step.cryptobot.model.binance.dto.AvgPriceDto;
import step.cryptobot.model.binance.dto.BookTickerDto;
import step.cryptobot.model.binance.dto.KlineDto;
import step.cryptobot.model.binance.dto.OrderBookDto;
import step.cryptobot.model.binance.dto.Ticker24hrDto;
import step.cryptobot.model.binance.dto.TickerDto;
import step.cryptobot.model.binance.dto.TickerPriceDto;
import step.cryptobot.model.binance.dto.TradeDto;
import step.cryptobot.output.binance.rest.AbstractBinanceClient;
import step.cryptobot.output.binance.rest.market.BinanceMarketDataClient;

import java.util.List;

@Service
public class BinanceMarketDataClientImpl extends AbstractBinanceClient implements BinanceMarketDataClient {

    @Override
    public Mono<TickerPriceDto> getTickerPrice(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/ticker/price")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToMono(TickerPriceDto.class);
    }

    @Override
    public Mono<OrderBookDto> getOrderBook(String symbol, int limit) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/depth")
                        .queryParam("symbol", symbol)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(OrderBookDto.class);
    }

    @Override
    public Mono<List<TradeDto>> getRecentTrades(String symbol, int limit) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/trades")
                        .queryParam("symbol", symbol)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToFlux(TradeDto.class)
                .collectList();
    }

    @Override
    public Mono<List<TradeDto>> getHistoricalTrades(String symbol, Long fromId, int limit) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/historicalTrades")
                            .queryParam("symbol", symbol)
                            .queryParam("limit", limit);
                    if (fromId != null) {
                        uriBuilder.queryParam("fromId", fromId);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(TradeDto.class)
                .collectList();
    }

    @Override
    public Mono<List<AggTradeDto>> getAggregatedTrades(String symbol, Long fromId, Long startTime, Long endTime, int limit) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/aggTrades")
                            .queryParam("symbol", symbol)
                            .queryParam("limit", limit);
                    if (fromId != null) {
                        uriBuilder.queryParam("fromId", fromId);
                    }
                    if (startTime != null) {
                        uriBuilder.queryParam("startTime", startTime);
                    }
                    if (endTime != null) {
                        uriBuilder.queryParam("endTime", endTime);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(AggTradeDto.class)
                .collectList();
    }

    @Override
    public Mono<List<KlineDto>> getKlines(String symbol, String interval, Long startTime, Long endTime, int limit) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/klines")
                            .queryParam("symbol", symbol)
                            .queryParam("interval", interval)
                            .queryParam("limit", limit);
                    if (startTime != null) {
                        uriBuilder.queryParam("startTime", startTime);
                    }
                    if (endTime != null) {
                        uriBuilder.queryParam("endTime", endTime);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(KlineDto.class)
                .collectList();
    }

    @Override
    public Mono<List<KlineDto>> getUiKlines(String symbol, String interval, Long startTime, Long endTime, int limit) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/uiKlines")
                            .queryParam("symbol", symbol)
                            .queryParam("interval", interval)
                            .queryParam("limit", limit);
                    if (startTime != null) {
                        uriBuilder.queryParam("startTime", startTime);
                    }
                    if (endTime != null) {
                        uriBuilder.queryParam("endTime", endTime);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(KlineDto.class)
                .collectList();
    }

    @Override
    public Mono<AvgPriceDto> getCurrentAveragePrice(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/avgPrice")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToMono(AvgPriceDto.class);
    }

    @Override
    public Mono<Ticker24hrDto> get24hrTicker(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/ticker/24hr")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToMono(Ticker24hrDto.class);
    }

    @Override
    public Mono<List<Ticker24hrDto>> getAll24hrTickers() {
        return webClient.get()
                .uri("/api/v3/ticker/24hr")
                .retrieve()
                .bodyToFlux(Ticker24hrDto.class)
                .collectList();
    }

    @Override
    public Mono<TickerPriceDto> getSymbolPriceTicker(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/ticker/price")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToMono(TickerPriceDto.class);
    }

    @Override
    public Mono<List<TickerPriceDto>> getAllSymbolPriceTickers() {
        return webClient.get()
                .uri("/api/v3/ticker/price")
                .retrieve()
                .bodyToFlux(TickerPriceDto.class)
                .collectList();
    }

    @Override
    public Mono<BookTickerDto> getBookTicker(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/ticker/bookTicker")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToMono(BookTickerDto.class);
    }

    @Override
    public Mono<List<BookTickerDto>> getAllBookTickers() {
        return webClient.get()
                .uri("/api/v3/ticker/bookTicker")
                .retrieve()
                .bodyToFlux(BookTickerDto.class)
                .collectList();
    }

    @Override
    public Mono<TickerDto> getRollingTicker(String symbol, String windowSize, String type) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/ticker")
                        .queryParam("symbol", symbol)
                        .queryParam("windowSize", windowSize)
                        .queryParam("type", type)
                        .build())
                .retrieve()
                .bodyToMono(TickerDto.class);
    }
}
