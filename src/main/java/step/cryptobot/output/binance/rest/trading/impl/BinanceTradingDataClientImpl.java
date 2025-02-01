package step.cryptobot.output.binance.rest.trading.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.CancelReplaceOrderRequestDto;
import step.cryptobot.model.binance.dto.CancelReplaceOrderResponseDto;
import step.cryptobot.model.binance.dto.OrderCancelResponseDto;
import step.cryptobot.model.binance.dto.OrderListResponseDto;
import step.cryptobot.model.binance.dto.OrderQueryResponseDto;
import step.cryptobot.model.binance.dto.OrderRequestDto;
import step.cryptobot.model.binance.dto.OrderResponseDto;
import step.cryptobot.model.binance.dto.SorOrderRequestDto;
import step.cryptobot.model.binance.dto.SorOrderResponseDto;
import step.cryptobot.model.binance.dto.SorOrderTestResponseDto;
import step.cryptobot.model.binance.dto.TestOrderResponseDto;
import step.cryptobot.output.binance.rest.AbstractBinanceClient;
import step.cryptobot.output.binance.rest.trading.BinanceTradingDataClient;

import java.util.List;

@Service
public class BinanceTradingDataClientImpl extends AbstractBinanceClient implements BinanceTradingDataClient {

    @Override
    public Mono<OrderResponseDto> newOrder(OrderRequestDto orderRequest) {
        return webClient.post()
                .uri("/api/v3/order")
                .bodyValue(orderRequest)
                .retrieve()
                .bodyToMono(OrderResponseDto.class);
    }

    @Override
    public Mono<TestOrderResponseDto> testNewOrder(OrderRequestDto orderRequest) {
        return webClient.post()
                .uri("/api/v3/order/test")
                .bodyValue(orderRequest)
                .retrieve()
                .bodyToMono(TestOrderResponseDto.class);
    }

    @Override
    public Mono<OrderQueryResponseDto> queryOrder(String symbol, Long orderId, String origClientOrderId, Long timestamp, Long recvWindow) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/order")
                            .queryParam("symbol", symbol)
                            .queryParam("timestamp", timestamp);
                    if (orderId != null) {
                        uriBuilder.queryParam("orderId", orderId);
                    }
                    if (origClientOrderId != null) {
                        uriBuilder.queryParam("origClientOrderId", origClientOrderId);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(OrderQueryResponseDto.class);
    }

    @Override
    public Mono<OrderCancelResponseDto> cancelOrder(String symbol, Long orderId, String origClientOrderId, Long timestamp, Long recvWindow) {
        return webClient.delete()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/order")
                            .queryParam("symbol", symbol)
                            .queryParam("timestamp", timestamp);
                    if (orderId != null) {
                        uriBuilder.queryParam("orderId", orderId);
                    }
                    if (origClientOrderId != null) {
                        uriBuilder.queryParam("origClientOrderId", origClientOrderId);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(OrderCancelResponseDto.class);
    }

    @Override
    public Mono<List<OrderCancelResponseDto>> cancelAllOpenOrders(String symbol, Long timestamp, Long recvWindow) {
        return webClient.delete()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/openOrders")
                            .queryParam("symbol", symbol)
                            .queryParam("timestamp", timestamp);
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(OrderCancelResponseDto.class)
                .collectList();
    }

    @Override
    public Mono<CancelReplaceOrderResponseDto> cancelReplaceOrder(CancelReplaceOrderRequestDto request) {
        return webClient.post()
                .uri("/api/v3/order/cancelReplace")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CancelReplaceOrderResponseDto.class);
    }

    @Override
    public Mono<OrderListResponseDto> queryOrderList(Long orderListId, String origClientOrderId, Long timestamp, Long recvWindow) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/orderList")
                            .queryParam("timestamp", timestamp);
                    if (orderListId != null) {
                        uriBuilder.queryParam("orderListId", orderListId);
                    }
                    if (origClientOrderId != null) {
                        uriBuilder.queryParam("origClientOrderId", origClientOrderId);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(OrderListResponseDto.class);
    }

    @Override
    public Mono<List<OrderListResponseDto>> queryAllOrderLists(String symbol, Long fromId, Long startTime, Long endTime, int limit, Long timestamp, Long recvWindow) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/allOrderList")
                            .queryParam("symbol", symbol)
                            .queryParam("limit", limit)
                            .queryParam("timestamp", timestamp);
                    if (fromId != null) {
                        uriBuilder.queryParam("fromId", fromId);
                    }
                    if (startTime != null) {
                        uriBuilder.queryParam("startTime", startTime);
                    }
                    if (endTime != null) {
                        uriBuilder.queryParam("endTime", endTime);
                    }
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(OrderListResponseDto.class)
                .collectList();
    }

    @Override
    public Mono<List<OrderListResponseDto>> queryOpenOrderLists(Long timestamp, Long recvWindow) {
        return webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/api/v3/openOrderList")
                            .queryParam("timestamp", timestamp);
                    if (recvWindow != null) {
                        uriBuilder.queryParam("recvWindow", recvWindow);
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(OrderListResponseDto.class)
                .collectList();
    }

    @Override
    public Mono<SorOrderResponseDto> sorNewOrder(SorOrderRequestDto request) {
        return webClient.post()
                .uri("/api/v3/sor/order")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SorOrderResponseDto.class);
    }

    @Override
    public Mono<SorOrderTestResponseDto> testSorNewOrder(SorOrderRequestDto request) {
        return webClient.post()
                .uri("/api/v3/sor/order/test")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SorOrderTestResponseDto.class);
    }
}
