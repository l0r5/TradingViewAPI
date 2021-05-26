package ch.l0r5.TradingViewAPI.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WebhookController {

    @PostMapping(path = "/trigger", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> triggerSignal(@RequestBody Map<String, Object> signal) {
        log.info("Received object: {}", signal);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
