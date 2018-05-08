package com.jvirriel.testrestful.backend.configuration.logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggerProducer {

    @Value("${jvirriel.logger.topic}")
    private String topic;

    private final KafkaTemplate<String, LoggerLog> kafkaTemplate;

    @Autowired
    public LoggerProducer(KafkaTemplate<String, LoggerLog> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void log(Throwable t) {
        kafkaTemplate.send(this.topic, new LoggerLog(t));
    }
}
