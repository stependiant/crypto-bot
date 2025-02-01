package step.cryptobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoBinanceBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoBinanceBotApplication.class, args);
    }

}
