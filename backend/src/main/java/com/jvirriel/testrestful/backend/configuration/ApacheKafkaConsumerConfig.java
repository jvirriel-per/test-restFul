package com.jvirriel.testrestful.backend.configuration;

import com.jvirriel.testrestful.backend.bus.Listener;
import com.jvirriel.testrestful.backend.bus.Receiver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

import static com.jvirriel.testrestful.backend.configuration.KafkaConfigProperties.getConsumerConfigPropertiesWithStringString;

@Configuration
@EnableKafka
@ComponentScan("com.jvirriel.testrestful.backend")
public class ApacheKafkaConsumerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerConfigs() {
        return getConsumerConfigPropertiesWithStringString(bootstrapServers, "helloworld");
    }


    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Listener listener() {
        return new Listener();
    }

}