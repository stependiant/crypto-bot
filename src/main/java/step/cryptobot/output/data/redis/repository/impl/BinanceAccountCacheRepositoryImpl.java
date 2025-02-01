package step.cryptobot.output.data.redis.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.AccountInformationDto;
import step.cryptobot.model.enums.DataRedisTTL;
import step.cryptobot.output.data.redis.RedisCacheRepository;
import step.cryptobot.output.data.redis.repository.BinanceAccountCacheRepository;


@RequiredArgsConstructor
@Repository
public class BinanceAccountCacheRepositoryImpl implements BinanceAccountCacheRepository {

    private final RedisCacheRepository redisCacheRepository;

    @Override
    public Mono<Void> saveAccountInfo(String accountId, AccountInformationDto accountInfo) {
        String key = "account:" + accountId;
        return redisCacheRepository.save(key, accountInfo, DataRedisTTL.ACCOUNT_INFO_TTL);
    }

    @Override
    public Mono<AccountInformationDto> getAccountInfo(String accountId) {
        String key = "account:" + accountId;
        return redisCacheRepository.get(key, AccountInformationDto.class);
    }

    @Override
    public Mono<Void> deleteAccountInfo(String accountId) {
        String key = "account:" + accountId;
        return redisCacheRepository.delete(key);
    }
}
