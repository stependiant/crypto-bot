package step.cryptobot.output.binance.rest.general.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.ExchangeInfoDto;
import step.cryptobot.output.binance.rest.AbstractBinanceClient;
import step.cryptobot.output.binance.rest.general.BinanceGeneralDataClient;

@Service
public class BinanceGeneralDataClientImpl extends AbstractBinanceClient implements BinanceGeneralDataClient {

    @Override
    public void ping() {
        webClient.get()
                .uri("/api/v3/ping")
                .retrieve()
                .bodyToMono(String.class)
                .then();
    }

    @Override
    public Mono<Long> getServerTime() {
        return webClient.get()
                .uri("/api/v3/time")
                .retrieve()
                .bodyToMono(ServerTimeResponse.class)
                .map(ServerTimeResponse::getServerTime);
    }

    @Override
    public Mono<ExchangeInfoDto> getExchangeInfo() {
        return webClient.get()
                .uri("/api/v3/exchangeInfo")
                .retrieve()
                .bodyToMono(ExchangeInfoDto.class);
    }

    @Setter
    @Getter
    private static class ServerTimeResponse {
        private long serverTime;
    }
}
