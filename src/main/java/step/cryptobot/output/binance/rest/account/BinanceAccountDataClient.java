package step.cryptobot.output.binance.rest.account;

import reactor.core.publisher.Mono;
import java.util.List;
import step.cryptobot.model.binance.dto.AccountInformationDto;
import step.cryptobot.model.binance.dto.MyTradeDto;
import step.cryptobot.model.binance.dto.OrderRateLimitDto;
import step.cryptobot.model.binance.dto.PreventedMatchDto;
import step.cryptobot.model.binance.dto.AllocationDto;
import step.cryptobot.model.binance.dto.CommissionRatesDto;

public interface BinanceAccountDataClient {

    /**
     * Get current account information.
     * GET /api/v3/account
     *
     * @param omitZeroBalances if true, only non-zero balances will be returned
     * @param recvWindow the receive window (max 60000, optional)
     * @param timestamp current timestamp
     * @return Mono containing the account information
     */
    Mono<AccountInformationDto> getAccountInformation(Boolean omitZeroBalances, Long recvWindow, Long timestamp);

    /**
     * Get trades for a specific account and symbol.
     * GET /api/v3/myTrades
     *
     * @param symbol trading pair symbol
     * @param orderId order ID (optional)
     * @param startTime start time in milliseconds (optional)
     * @param endTime end time in milliseconds (optional)
     * @param fromId trade ID to fetch from (optional)
     * @param limit maximum number of trades to return (default 500; max 1000)
     * @param recvWindow the receive window (max 60000, optional)
     * @param timestamp current timestamp
     * @return Mono containing the list of trades
     */
    Mono<List<MyTradeDto>> getMyTrades(String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit, Long recvWindow, Long timestamp);

    /**
     * Displays the user's unfilled order count for all intervals.
     * GET /api/v3/rateLimit/order
     *
     * @param recvWindow the receive window (max 60000, optional)
     * @param timestamp current timestamp
     * @return Mono containing the list of order rate limit details
     */
    Mono<List<OrderRateLimitDto>> getUnfilledOrderCount(Long recvWindow, Long timestamp);

    /**
     * Displays the list of orders that were expired due to STP.
     * GET /api/v3/myPreventedMatches
     *
     * @param symbol trading pair symbol
     * @param preventedMatchId prevented match ID (optional)
     * @param orderId order ID (optional)
     * @param fromPreventedMatchId starting prevented match ID (optional)
     * @param limit maximum number of records to return (default 500; max 1000)
     * @param recvWindow the receive window (max 60000, optional)
     * @param timestamp current timestamp
     * @return Mono containing the list of prevented matches
     */
    Mono<List<PreventedMatchDto>> getMyPreventedMatches(String symbol, Long preventedMatchId, Long orderId, Long fromPreventedMatchId, Integer limit, Long recvWindow, Long timestamp);

    /**
     * Retrieves allocations resulting from SOR order placement.
     * GET /api/v3/myAllocations
     *
     * @param symbol trading pair symbol
     * @param startTime start time in milliseconds (optional)
     * @param endTime end time in milliseconds (optional)
     * @param fromAllocationId allocation ID to start from (optional)
     * @param limit maximum number of allocations to return (default 500; max 1000)
     * @param orderId order ID (optional)
     * @param recvWindow the receive window (max 60000, optional)
     * @param timestamp current timestamp (optional)
     * @return Mono containing the list of allocations
     */
    Mono<List<AllocationDto>> getMyAllocations(String symbol, Long startTime, Long endTime, Integer fromAllocationId, Integer limit, Long orderId, Long recvWindow, Long timestamp);

    /**
     * Get current account commission rates.
     * GET /api/v3/account/commission
     *
     * @param symbol trading pair symbol
     * @return Mono containing the commission rates information
     */
    Mono<CommissionRatesDto> getCommissionRates(String symbol);
}
