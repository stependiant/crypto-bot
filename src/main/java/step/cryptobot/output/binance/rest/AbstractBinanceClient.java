package step.cryptobot.output.binance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public abstract class AbstractBinanceClient {
    @Autowired
    protected WebClient webClient;
}
