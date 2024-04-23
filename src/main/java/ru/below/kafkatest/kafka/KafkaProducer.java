package ru.below.kafkatest.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class KafkaProduser {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProduser.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProduser(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("sendMessage sent %s", message));
        kafkaTemplate.send("topic2", message);
    }
}
