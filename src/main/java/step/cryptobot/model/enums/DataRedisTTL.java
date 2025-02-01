package step.cryptobot.model.enums;

/**
 * Defines Time-To-Live (TTL) values in seconds for various cached data in Redis.
 */
public final class DataRedisTTL {

    /**
     * TTL for exchange information (e.g., /api/v3/exchangeInfo)
     */
    public static final long EXCHANGE_INFO_TTL = 86400;

    /**
     * TTL for coins list
     */
    public static final long COINS_TTL = 3600;

    /**
     * TTL for ticker data
     */
    public static final long TICKER_TTL = 30;

    /**
     * TTL for order book data
     */
    public static final long ORDERBOOK_TTL = 60;

    /**
     * TTL for klines (candlestick) data
     */
    public static final long KLINES_TTL = 60;

    /**
     * TTL for average price data
     */
    public static final long AVG_PRICE_TTL = 30;

    /**
     * TTL for 24hr ticker data
     */
    public static final long TICKER_24HR_TTL = 60;

    /**
     * TTL for best bid/ask (book ticker) data
     */
    public static final long BOOK_TICKER_TTL = 30;

    /**
     * TTL for account information
     */
    public static final long ACCOUNT_INFO_TTL = 1800;

    /**
     * TTL for account trades data
     */
    public static final long ACCOUNT_TRADES_TTL = 300;

    /**
     * TTL for order rate data
     */
    public static final long ORDER_RATE_TTL = 300;

    /**
     * TTL for prevented matches data
     */
    public static final long PREVENTED_MATCHES_TTL = 300;

    /**
     * TTL for allocations data
     */
    public static final long ALLOCATIONS_TTL = 300;

    /**
     * TTL for commission data
     */
    public static final long COMMISSION_TTL = 300;

    /**
     * TTL for individual order details
     */
    public static final long ORDER_TTL = 300;

    /**
     * TTL for open orders data
     */
    public static final long OPEN_ORDERS_TTL = 60;

    /**
     * TTL for order list data (e.g., OCO orders)
     */
    public static final long ORDER_LIST_TTL = 60;

    /**
     * TTL for user data stream listenKey
     */
    public static final long USER_LISTEN_KEY_TTL = 3600;

    private DataRedisTTL() {}
}
