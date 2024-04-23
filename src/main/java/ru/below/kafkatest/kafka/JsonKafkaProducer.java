package ru.below.kafkatest.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.below.kafkatest.dto.User;

@Service
@AllArgsConstructor
public class JsonKafkaProduser {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProduser.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        LOGGER.info(String.format("sendMessage sent %s", user.toString()));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"topic2")
                .build();

        kafkaTemplate.send(message);
    }
}
