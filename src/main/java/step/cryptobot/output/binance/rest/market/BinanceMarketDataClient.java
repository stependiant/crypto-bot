package step.cryptobot.output.binance.rest.market;

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

import java.util.List;

public interface BinanceMarketDataClient {

    /**
     * Get the latest ticker price for the given symbol.
     * Endpoint: GET /api/v3/ticker/price
     *
     * @param symbol the trading pair symbol (e.g., "BTCUSDT")
     * @return Mono<TickerPriceDto> containing the ticker price information.
     */
    Mono<TickerPriceDto> getTickerPrice(String symbol);

    /**
     * Get the order book data for the given symbol.
     * Endpoint: GET /api/v3/depth
     *
     * @param symbol the trading pair symbol (e.g., "BTCUSDT")
     * @param limit  the limit for the number of bids and asks to return
     * @return Mono<OrderBookDto> containing the order book information.
     */
    Mono<OrderBookDto> getOrderBook(String symbol, int limit);

    /**
     * Get a list of recent trades for the given symbol.
     * Endpoint: GET /api/v3/trades
     *
     * @param symbol the trading pair symbol (e.g., "BTCUSDT")
     * @param limit  the maximum number of trades to return (default is 500; max is 1000)
     * @return Mono<List<TradeDto>> containing the list of recent trades.
     */
    Mono<List<TradeDto>> getRecentTrades(String symbol, int limit);

    /**
     * Get a list of historical trades for the given symbol.
     * Endpoint: GET /api/v3/historicalTrades
     *
     * @param symbol the trading pair symbol
     * @param fromId trade id to fetch from (optional)
     * @param limit  maximum number of trades to return
     * @return Mono<List<TradeDto>> containing historical trades.
     */
    Mono<List<TradeDto>> getHistoricalTrades(String symbol, Long fromId, int limit);

    /**
     * Get a list of aggregated (compressed) trades for the given symbol.
     * Endpoint: GET /api/v3/aggTrades
     *
     * @param symbol    the trading pair symbol
     * @param fromId    the aggregate trade id to fetch from (optional)
     * @param startTime the start time in milliseconds (optional)
     * @param endTime   the end time in milliseconds (optional)
     * @param limit     maximum number of aggregated trades to return
     * @return Mono<List<AggTradeDto>> containing the aggregated trades.
     */
    Mono<List<AggTradeDto>> getAggregatedTrades(String symbol, Long fromId, Long startTime, Long endTime, int limit);

    /**
     * Get candlestick (kline) data for the given symbol.
     * Endpoint: GET /api/v3/klines
     *
     * @param symbol    the trading pair symbol
     * @param interval  candlestick interval (e.g., "1m", "5m", "1h", etc.)
     * @param startTime start time in milliseconds (optional)
     * @param endTime   end time in milliseconds (optional)
     * @param limit     maximum number of klines to return
     * @return Mono<List<KlineDto>> containing the candlestick data.
     */
    Mono<List<KlineDto>> getKlines(String symbol, String interval, Long startTime, Long endTime, int limit);

    /**
     * Get UI optimized kline data for the given symbol.
     * Endpoint: GET /api/v3/uiKlines
     *
     * @param symbol    the trading pair symbol
     * @param interval  candlestick interval
     * @param startTime start time in milliseconds (optional)
     * @param endTime   end time in milliseconds (optional)
     * @param limit     maximum number of klines to return
     * @return Mono<List<KlineDto>> containing the UI kline data.
     */
    Mono<List<KlineDto>> getUiKlines(String symbol, String interval, Long startTime, Long endTime, int limit);

    /**
     * Get the current average price for the given symbol.
     * Endpoint: GET /api/v3/avgPrice
     *
     * @param symbol the trading pair symbol
     * @return Mono<AvgPriceDto> containing the average price information.
     */
    Mono<AvgPriceDto> getCurrentAveragePrice(String symbol);

    /**
     * Get 24-hour ticker price change statistics for the given symbol.
     * Endpoint: GET /api/v3/ticker/24hr (with symbol)
     *
     * @param symbol the trading pair symbol
     * @return Mono<Ticker24hrDto> containing the 24hr ticker statistics.
     */
    Mono<Ticker24hrDto> get24hrTicker(String symbol);

    /**
     * Get 24-hour ticker price change statistics for all symbols.
     * Endpoint: GET /api/v3/ticker/24hr (without symbol)
     *
     * @return Mono<List<Ticker24hrDto>> containing the statistics for all symbols.
     */
    Mono<List<Ticker24hrDto>> getAll24hrTickers();

    /**
     * Get the symbol price ticker for a given symbol.
     * Endpoint: GET /api/v3/ticker/price (with symbol)
     *
     * @param symbol the trading pair symbol
     * @return Mono<TickerPriceDto> containing the price information.
     */
    Mono<TickerPriceDto> getSymbolPriceTicker(String symbol);

    /**
     * Get the symbol price ticker for all symbols.
     * Endpoint: GET /api/v3/ticker/price (without symbol)
     *
     * @return Mono<List<TickerPriceDto>> containing the price information for all symbols.
     */
    Mono<List<TickerPriceDto>> getAllSymbolPriceTickers();

    /**
     * Get the best bid/ask (order book ticker) for a given symbol.
     * Endpoint: GET /api/v3/ticker/bookTicker (with symbol)
     *
     * @param symbol the trading pair symbol
     * @return Mono<BookTickerDto> containing the best bid and ask information.
     */
    Mono<BookTickerDto> getBookTicker(String symbol);

    /**
     * Get the best bid/ask (order book ticker) for all symbols.
     * Endpoint: GET /api/v3/ticker/bookTicker (without symbol)
     *
     * @return Mono<List<BookTickerDto>> containing the best bid and ask information for all symbols.
     */
    Mono<List<BookTickerDto>> getAllBookTickers();

    /**
     * Get rolling window ticker data for a given symbol.
     * Note: This endpoint is different from the 24hr ticker.
     * Endpoint: GET /api/v3/ticker
     *
     * @param symbol     the trading pair symbol
     * @param windowSize window size (e.g., "1m", "1h", "1d", etc.)
     * @param type       response type ("FULL" or "MINI")
     * @return Mono<TickerDto> containing the rolling window ticker data.
     */
    Mono<TickerDto> getRollingTicker(String symbol, String windowSize, String type);
}
