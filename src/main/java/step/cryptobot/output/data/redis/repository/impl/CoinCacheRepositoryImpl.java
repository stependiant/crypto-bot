package step.cryptobot.output.data.redis.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import step.cryptobot.model.enums.DataRedisKey;
import step.cryptobot.model.enums.DataRedisTTL;
import step.cryptobot.output.data.redis.RedisCacheRepository;
import step.cryptobot.output.data.redis.repository.CoinCacheRepository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CoinCacheRepositoryImpl implements CoinCacheRepository {

    private final RedisCacheRepository redisCacheRepository;

    @Override
    public Mono<Void> saveCoins(List<String> coins) {
        return redisCacheRepository.save(DataRedisKey.COINS_LIST, coins, DataRedisTTL.COINS_TTL);
    }

    @Override
    public Mono<List<String>> getCoins() {
        return redisCacheRepository.get(DataRedisKey.COINS_LIST, List.class)
                .map(cached -> (List<String>) cached);
    }

    @Override
    public Mono<Void> deleteCoins() {
        return redisCacheRepository.delete(DataRedisKey.COINS_LIST);
    }
}
