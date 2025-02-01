package step.cryptobot.output.data.redis.repository;

import reactor.core.publisher.Mono;
import java.util.List;

/**
 * Repository interface for caching coin information in Redis.
 */
public interface CoinCacheRepository {

    /**
     * Save the list of coins in Redis.
     *
     * @param coins The list of coins (e.g., unique base assets) to cache.
     * @return Mono signaling when the operation is complete.
     */
    Mono<Void> saveCoins(List<String> coins);

    /**
     * Retrieve the list of cached coins.
     *
     * @return Mono emitting the list of coins, or empty if not found.
     */
    Mono<List<String>> getCoins();

    /**
     * Delete the cached coin list from Redis.
     *
     * @return Mono signaling when the deletion is complete.
     */
    Mono<Void> deleteCoins();
}
