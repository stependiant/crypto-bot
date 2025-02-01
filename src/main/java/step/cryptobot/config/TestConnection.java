package step.cryptobot.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import step.cryptobot.output.binance.rest.BinanceApiClient;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestConnection {

    private final BinanceApiClient binanceApiClient;

    @PostConstruct
    public void pingToBinance() {
        try {
            log.info("Processing ping binance api");
            binanceApiClient.getGeneralDataClient().ping();
            log.info("Ping to binance api successful");
        } catch (Exception e) {
            log.error("Error processing ping to binance", e);
        }
    }
}
