package step.cryptobot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.SymbolInfoDto;
import step.cryptobot.output.binance.rest.BinanceApiClient;
import step.cryptobot.output.data.redis.repository.CoinCacheRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoinService {

    private final BinanceApiClient binanceApiClient;
    private final CoinCacheRepository coinCacheRepository;

    public Mono<List<String>> getCachedCoins() {
        return binanceApiClient.getGeneralDataClient().getExchangeInfo()
                .map(exchangeInfo -> exchangeInfo.getSymbols().stream()
                        .map(SymbolInfoDto::getBaseAsset)
                        .distinct()
                        .collect(Collectors.toList()))
                .flatMap(coins -> coinCacheRepository.saveCoins(coins).thenReturn(coins));
    }
}
