package ch.l0r5.TradingViewAPI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TelegramService {

    private final RestTemplate restTemplate;

    public TelegramService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void broadcastMessage(String message) {
        log.info("Broadcasting message to telegram: {}", message);
        String url = null;
        try {
            url = "https://api.telegram.org/bot:api_key/sendMessage?chat_id=-1001157321659&text=" + message;
        } catch (Exception e) {
            log.error("Error encoding URL {}", String.valueOf(e));
        }
        String response = restTemplate.getForObject(url, String.class);
        log.info("Received response: {}", response);
    }

}
