package com.jvirriel.testrestful.backend.configuration.logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

import static com.jvirriel.testrestful.backend.configuration.KafkaConfigProperties.getProducerConfigPropertiesWithStringJson;

@Configuration
public class KafkaLoggerProducerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        return getProducerConfigPropertiesWithStringJson(bootstrapServers);
    }


    @Bean
    public ProducerFactory<String, LoggerLog> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }


    @Bean
    public KafkaTemplate<String, LoggerLog> loggerKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
