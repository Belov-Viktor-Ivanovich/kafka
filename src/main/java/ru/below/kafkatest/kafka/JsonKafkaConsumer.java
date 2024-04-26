package ru.below.kafkatest.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.below.kafkatest.dto.User;

@Service
@RequiredArgsConstructor
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "topic2", groupId = "group1")
    public void consume(User user){
        LOGGER.info(String.format("message send " + user));
    }
}
