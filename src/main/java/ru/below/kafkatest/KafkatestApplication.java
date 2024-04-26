package ru.below.kafkatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkatestApplication {

	//запустить kafka server
	//bin/windows/kafka-server-start.bat config/server.properties
	//bin/windows/zookeeper-server-start.bat config/zookeeper.properties
	public static void main(String[] args) {
		SpringApplication.run(KafkatestApplication.class, args);
	}

}
