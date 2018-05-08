package com.jvirriel.testrestful.backend.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

public class KafkaConfigProperties {
    public static Map<String, Object> getConsumerConfigPropertiesWithStringJason(String bootstrapServers,
                                                                                 String groupId) {
        return getConsumerProperties(StringDeserializer.class, JsonDeserializer.class, bootstrapServers, groupId);
    }

    public static Map<String, Object> getProducerConfigPropertiesWithStringJson(String bootstrapServers) {
        return getProducerProperties(StringSerializer.class, JsonSerializer.class, bootstrapServers);
    }

    public static Map<String, Object> getConsumerConfigPropertiesWithStringString(String bootstrapServers,
                                                                                  String groupId) {
        return getConsumerProperties(StringDeserializer.class, StringDeserializer.class, bootstrapServers, groupId);
    }

    public static Map<String, Object> getProducerConfigPropertiesWithStringString(String bootstrapServers) {
        return getProducerProperties(StringSerializer.class, StringSerializer.class, bootstrapServers);
    }

    public static <K, V> Map<String, Object> getConsumerProperties(Class<K> keyClass, Class<V> valueClass, String
            bootstrapServers, String groupId) {
        return new HashMap<String, Object>() {
            {
                put(KEY_DESERIALIZER_CLASS_CONFIG, keyClass);
                put(VALUE_DESERIALIZER_CLASS_CONFIG, valueClass);
                put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
                put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            }
        };
    }

    public static <K, V> Map<String, Object> getProducerProperties(Class<K> keyClass, Class<V> valueClass, String
            bootstrapServers) {
        return new HashMap<String, Object>() {
            {
                put(KEY_SERIALIZER_CLASS_CONFIG, keyClass);
                put(VALUE_SERIALIZER_CLASS_CONFIG, valueClass);
                put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            }
        };
    }
}