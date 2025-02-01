package step.cryptobot.output.data.redis.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import step.cryptobot.output.data.redis.RedisCacheRepository;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class RedisCacheRepositoryImpl implements RedisCacheRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public <T> Mono<Void> save(String key, T data, long ttlInSeconds) {
        try {
            String jsonData = objectMapper.writeValueAsString(data);
            return Mono.fromRunnable(() ->
                    redisTemplate.opsForValue().set(key, jsonData, Duration.ofSeconds(ttlInSeconds))
            );
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }
    }

    @Override
    public <T> Mono<T> get(String key, Class<T> clazz) {
        return Mono.fromCallable(() -> redisTemplate.opsForValue().get(key))
                .flatMap(json -> {
                    if (json == null) {
                        return Mono.empty();
                    }
                    try {
                        T data = objectMapper.readValue(json, clazz);
                        return Mono.just(data);
                    } catch (JsonProcessingException e) {
                        return Mono.error(e);
                    }
                });
    }

    @Override
    public Mono<Void> delete(String key) {
        return Mono.fromRunnable(() -> redisTemplate.delete(key));
    }
}
