package ru.below.kafkatest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.below.kafkatest.dto.User;
import ru.below.kafkatest.kafka.JsonKafkaProducer;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class JsonMessageController {
    private final JsonKafkaProducer jsonKafkaProducer;
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message"+user.toString());
    }
}
