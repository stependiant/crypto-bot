package step.cryptobot.output.binance.rest.trading;

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

import java.util.List;

public interface BinanceTradingDataClient {

    /**
     * Create a new order.
     * POST /api/v3/order
     *
     * @param orderRequest the order request parameters
     * @return Mono<OrderResponseDto> with the order response
     */
    Mono<OrderResponseDto> newOrder(OrderRequestDto orderRequest);

    /**
     * Test new order creation.
     * POST /api/v3/order/test
     *
     * @param orderRequest the order request parameters
     * @return Mono<TestOrderResponseDto> with the test response
     */
    Mono<TestOrderResponseDto> testNewOrder(OrderRequestDto orderRequest);

    /**
     * Query an order's status.
     * GET /api/v3/order
     *
     * @param symbol the trading pair symbol
     * @param orderId the order ID (optional)
     * @param origClientOrderId the original client order ID (optional)
     * @param timestamp the current timestamp
     * @param recvWindow the receive window (optional)
     * @return Mono<OrderQueryResponseDto> with the order query response
     */
    Mono<OrderQueryResponseDto> queryOrder(String symbol, Long orderId, String origClientOrderId, Long timestamp, Long recvWindow);

    /**
     * Cancel an existing order.
     * DELETE /api/v3/order
     *
     * @param symbol the trading pair symbol
     * @param orderId the order ID (optional)
     * @param origClientOrderId the original client order ID (optional)
     * @param timestamp the current timestamp
     * @param recvWindow the receive window (optional)
     * @return Mono<OrderCancelResponseDto> with the cancel order response
     */
    Mono<OrderCancelResponseDto> cancelOrder(String symbol, Long orderId, String origClientOrderId, Long timestamp, Long recvWindow);

    /**
     * Cancel all open orders for a symbol.
     * DELETE /api/v3/openOrders
     *
     * @param symbol the trading pair symbol
     * @param timestamp the current timestamp
     * @param recvWindow the receive window (optional)
     * @return Mono<List<OrderCancelResponseDto>> with the responses for canceled orders
     */
    Mono<List<OrderCancelResponseDto>> cancelAllOpenOrders(String symbol, Long timestamp, Long recvWindow);

    /**
     * Cancel an existing order and send a new order.
     * POST /api/v3/order/cancelReplace
     *
     * @param request the cancel-replace order request parameters
     * @return Mono<CancelReplaceOrderResponseDto> with the cancel-replace order response
     */
    Mono<CancelReplaceOrderResponseDto> cancelReplaceOrder(CancelReplaceOrderRequestDto request);

    /**
     * Query a specific order list.
     * GET /api/v3/orderList
     *
     * @param orderListId the order list ID (optional)
     * @param origClientOrderId the original client order ID for the order list (optional)
     * @param timestamp the current timestamp
     * @param recvWindow the receive window (optional)
     * @return Mono<OrderListResponseDto> with the order list details
     */
    Mono<OrderListResponseDto> queryOrderList(Long orderListId, String origClientOrderId, Long timestamp, Long recvWindow);

    /**
     * Query all order lists for a symbol.
     * GET /api/v3/allOrderList
     *
     * @param symbol the trading pair symbol
     * @param fromId order list ID to start from (optional)
     * @param startTime start time in milliseconds (optional)
     * @param endTime end time in milliseconds (optional)
     * @param limit maximum number of order lists to return
     * @param timestamp the current timestamp
     * @param recvWindow the receive window (optional)
     * @return Mono<List<OrderListResponseDto>> with the list of order lists
     */
    Mono<List<OrderListResponseDto>> queryAllOrderLists(String symbol, Long fromId, Long startTime, Long endTime, int limit, Long timestamp, Long recvWindow);

    /**
     * Query all open order lists.
     * GET /api/v3/openOrderList
     *
     * @param timestamp the current timestamp
     * @param recvWindow the receive window (optional)
     * @return Mono<List<OrderListResponseDto>> with the open order lists
     */
    Mono<List<OrderListResponseDto>> queryOpenOrderLists(Long timestamp, Long recvWindow);

    /**
     * Place a new order using Smart Order Routing (SOR).
     * POST /api/v3/sor/order
     *
     * @param request the SOR order request parameters
     * @return Mono<SorOrderResponseDto> with the SOR order response
     */
    Mono<SorOrderResponseDto> sorNewOrder(SorOrderRequestDto request);

    /**
     * Test new order creation using SOR.
     * POST /api/v3/sor/order/test
     *
     * @param request the SOR order request parameters
     * @return Mono<SorOrderTestResponseDto> with the SOR test order response
     */
    Mono<SorOrderTestResponseDto> testSorNewOrder(SorOrderRequestDto request);
}
