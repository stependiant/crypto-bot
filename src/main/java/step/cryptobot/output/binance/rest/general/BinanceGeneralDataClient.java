package step.cryptobot.output.binance.rest.general;

import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.ExchangeInfoDto;

public interface BinanceGeneralDataClient {

    /**
     * Implements GET /api/v3/ping endpoint.
     * This endpoint returns an empty JSON object {}.
     */
    void ping();

    /**
     * Implements GET /api/v3/time endpoint.
     * This endpoint returns a JSON with the current server time, e.g.:
     * { "serverTime": 1738368927908 }
     *
     * @return Mono<Long> representing the current server time in milliseconds.
     */
    Mono<Long> getServerTime();

    /**
     * Implements GET /api/v3/exchangeInfo endpoint.
     * This endpoint returns exchange information, including rate limits, filters, and symbol info.
     *
     * @return Mono<ExchangeInfoDto> containing the exchange information.
     */
    Mono<ExchangeInfoDto> getExchangeInfo();
}
