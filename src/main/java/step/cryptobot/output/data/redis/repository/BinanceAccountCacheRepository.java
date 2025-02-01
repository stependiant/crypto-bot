package step.cryptobot.output.data.redis.repository;

import reactor.core.publisher.Mono;
import step.cryptobot.model.binance.dto.AccountInformationDto;

public interface BinanceAccountCacheRepository {

    /**
     * Save account information for a given account identifier.
     *
     * @param accountId   The account identifier.
     * @param accountInfo The account information object.
     * @return Mono signaling completion.
     */
    Mono<Void> saveAccountInfo(String accountId, AccountInformationDto accountInfo);

    /**
     * Retrieve account information by account identifier.
     *
     * @param accountId The account identifier.
     * @return Mono emitting the account information.
     */
    Mono<AccountInformationDto> getAccountInfo(String accountId);

    /**
     * Delete account information from cache.
     *
     * @param accountId The account identifier.
     * @return Mono signaling completion.
     */
    Mono<Void> deleteAccountInfo(String accountId);
}
