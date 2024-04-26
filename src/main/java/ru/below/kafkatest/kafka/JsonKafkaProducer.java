package ru.below.kafkatest.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.below.kafkatest.dto.User;

@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(User user) {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "topic2")
                .build();

        kafkaTemplate.send(message);
    }
}
