package ru.below.kafkatest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.below.kafkatest.kafka.KafkaProducer;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class MessageController {
    public final KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam ("message")String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic "+message);
    }

}
