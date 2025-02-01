package step.cryptobot.model.enums;

/**
 * Defines Redis key naming conventions for caching various Binance data.
 */
public final class DataRedisKey {

    /**
     * Key for caching exchange information (e.g., from /api/v3/exchangeInfo).
     */
    public static final String EXCHANGE_INFO = "exchange:info";

    /**
     * Key for caching the list of coins (unique base assets).
     */
    public static final String COINS_LIST = "coins:list";

    /**
     * Key pattern for ticker data of a given symbol.
     * Use String.format(TICKER, symbol) to obtain the actual key.
     * Example: ticker:BTCUSDT
     */
    public static final String TICKER = "ticker:%s";

    /**
     * Key pattern for order book data for a given symbol and limit.
     * Use String.format(ORDERBOOK, symbol, limit) to obtain the actual key.
     * Example: orderbook:BTCUSDT:100
     */
    public static final String ORDERBOOK = "orderbook:%s:%d";

    /**
     * Key pattern for candlestick (klines) data for a given symbol and interval.
     * Use String.format(KLINES, symbol, interval) to obtain the actual key.
     * Example: klines:BTCUSDT:1m
     */
    public static final String KLINES = "klines:%s:%s";

    /**
     * Key pattern for average price data for a given symbol.
     * Use String.format(AVG_PRICE, symbol) to obtain the actual key.
     * Example: avgPrice:BTCUSDT
     */
    public static final String AVG_PRICE = "avgPrice:%s";

    /**
     * Key pattern for 24-hour ticker data for a given symbol.
     * Use String.format(TICKER_24HR, symbol) to obtain the actual key.
     * Example: ticker24hr:BTCUSDT
     */
    public static final String TICKER_24HR = "ticker24hr:%s";

    /**
     * Key pattern for best bid/ask (book ticker) data for a given symbol.
     * Use String.format(BOOK_TICKER, symbol) to obtain the actual key.
     * Example: bookTicker:BTCUSDT
     */
    public static final String BOOK_TICKER = "bookTicker:%s";

    /**
     * Key pattern for account information for a given user id.
     * Use String.format(ACCOUNT_INFO, uid) to obtain the actual key.
     * Example: account:354937868
     */
    public static final String ACCOUNT_INFO = "account:%s";

    /**
     * Key pattern for caching account trades for a given user id and symbol.
     * Use String.format(ACCOUNT_TRADES, uid, symbol) to obtain the actual key.
     * Example: trades:account:354937868:BTCUSDT
     */
    public static final String ACCOUNT_TRADES = "trades:account:%s:%s";

    /**
     * Key pattern for caching order rate information for a given user id.
     * Use String.format(ORDER_RATE, uid) to obtain the actual key.
     * Example: orderRate:354937868
     */
    public static final String ORDER_RATE = "orderRate:%s";

    /**
     * Key pattern for caching prevented matches for a given user id and symbol.
     * Use String.format(PREVENTED_MATCHES, uid, symbol) to obtain the actual key.
     * Example: preventedMatches:354937868:BTCUSDT
     */
    public static final String PREVENTED_MATCHES = "preventedMatches:%s:%s";

    /**
     * Key pattern for caching allocations for a given user id and symbol.
     * Use String.format(ALLOCATIONS, uid, symbol) to obtain the actual key.
     * Example: allocations:354937868:BTCUSDT
     */
    public static final String ALLOCATIONS = "allocations:%s:%s";

    /**
     * Key pattern for caching commission information for a given user id and symbol.
     * Use String.format(COMMISSION, uid, symbol) to obtain the actual key.
     * Example: commission:354937868:BTCUSDT
     */
    public static final String COMMISSION = "commission:%s:%s";

    /**
     * Key pattern for caching a single order's details.
     * Use String.format(ORDER, orderId) to obtain the actual key.
     * Example: order:123456
     */
    public static final String ORDER = "order:%s";

    /**
     * Key pattern for caching open orders for a given symbol.
     * Use String.format(OPEN_ORDERS, symbol) to obtain the actual key.
     * Example: openOrders:BTCUSDT
     */
    public static final String OPEN_ORDERS = "openOrders:%s";

    /**
     * Key pattern for caching order list data (e.g., OCO orders) for a given list id.
     * Use String.format(ORDER_LIST, listId) to obtain the actual key.
     * Example: orderList:789
     */
    public static final String ORDER_LIST = "orderList:%s";

    /**
     * Key pattern for caching user data stream listenKey for a given user id.
     * Use String.format(USER_LISTEN_KEY, uid) to obtain the actual key.
     * Example: user:listenKey:354937868
     */
    public static final String USER_LISTEN_KEY = "user:listenKey:%s";

    private DataRedisKey() {}
}
