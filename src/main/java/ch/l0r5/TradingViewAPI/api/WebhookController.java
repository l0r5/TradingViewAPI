package ch.l0r5.TradingViewAPI.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.l0r5.TradingViewAPI.TelegramService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WebhookController {

    private final TelegramService telegramService;

    public WebhookController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping(path = "/telegram", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<HttpStatus> triggerSignal(@RequestBody String message) {
        log.info("Received object: {}", message);
        telegramService.broadcastMessage(message);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
