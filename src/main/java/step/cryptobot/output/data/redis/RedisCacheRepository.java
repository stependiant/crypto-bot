package step.cryptobot.output.data.redis;

import reactor.core.publisher.Mono;

public interface RedisCacheRepository {

    /**
     * Save an object as JSON in Redis with a specified TTL.
     *
     * @param key          The Redis key.
     * @param data         The data object to store.
     * @param ttlInSeconds Time to live in seconds.
     * @param <T>          Type of data.
     * @return Mono signaling when operation is complete.
     */
    <T> Mono<Void> save(String key, T data, long ttlInSeconds);

    /**
     * Retrieve an object from Redis by its key.
     *
     * @param key   The Redis key.
     * @param clazz The class of the object.
     * @param <T>   Type of the object.
     * @return Mono emitting the object if found.
     */
    <T> Mono<T> get(String key, Class<T> clazz);

    /**
     * Delete a value from Redis by its key.
     *
     * @param key The Redis key.
     * @return Mono signaling when the deletion is complete.
     */
    Mono<Void> delete(String key);
}
