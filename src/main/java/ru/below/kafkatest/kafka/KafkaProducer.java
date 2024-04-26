package ru.below.kafkatest.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("topic2",message);
        LOGGER.info(String.format("message send " + message));
    }
}
