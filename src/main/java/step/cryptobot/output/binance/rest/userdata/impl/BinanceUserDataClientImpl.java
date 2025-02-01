package step.cryptobot.output.binance.rest.userdata.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.output.binance.rest.AbstractBinanceClient;
import step.cryptobot.output.binance.rest.userdata.BinanceUserDataClient;

@Service
public class BinanceUserDataClientImpl extends AbstractBinanceClient implements BinanceUserDataClient {

    @Data
    private static class ListenKeyResponse {
        private String listenKey;
    }

    @Override
    public Mono<String> startUserDataStream() {
        return webClient.post()
                .uri("/api/v3/userDataStream")
                .retrieve()
                .bodyToMono(ListenKeyResponse.class)
                .map(ListenKeyResponse::getListenKey);
    }

    @Override
    public Mono<Void> keepAliveUserDataStream(String listenKey) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/userDataStream")
                        .queryParam("listenKey", listenKey)
                        .build())
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Mono<Void> closeUserDataStream(String listenKey) {
        return webClient.delete()
                .uri(uriBuilder -> uriBuilder.path("/api/v3/userDataStream")
                        .queryParam("listenKey", listenKey)
                        .build())
                .retrieve()
                .bodyToMono(Void.class);
    }
}
