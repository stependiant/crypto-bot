package step.cryptobot.output.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import step.cryptobot.service.CoinService;

@RequiredArgsConstructor
@Slf4j
@Component
public class CoinScheduler {

    private final CoinService coinService;

    @Scheduled(fixedRate = 5000)
    public void updateCoins() {
        log.info("Updating coins");
        coinService.getCachedCoins()
                .subscribe(coins -> log.info("Updated coins: {}", coins),
                        error -> log.error("Error updating coins", error));
    }

}
