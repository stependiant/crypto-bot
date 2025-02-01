package step.cryptobot.output.binance.rest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import step.cryptobot.output.binance.rest.account.BinanceAccountDataClient;
import step.cryptobot.output.binance.rest.general.BinanceGeneralDataClient;
import step.cryptobot.output.binance.rest.market.BinanceMarketDataClient;
import step.cryptobot.output.binance.rest.trading.BinanceTradingDataClient;
import step.cryptobot.output.binance.rest.userdata.BinanceUserDataClient;

@Getter
@RequiredArgsConstructor
@Service
public class BinanceApiClient {
    private final BinanceMarketDataClient marketDataClient;
    private final BinanceGeneralDataClient generalDataClient;
    private final BinanceTradingDataClient tradingDataClient;
    private final BinanceAccountDataClient accountDataClient;
    private final BinanceUserDataClient userDataClient;
}
