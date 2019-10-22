package com.example.reactive.kafkaproducer.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.util.Map;

@Configuration
@EnableConfigurationProperties(KafkaConfigurationProperties.class)
public class KafkaConfiguration {

  private final KafkaConfigurationProperties properties;

  public KafkaConfiguration(KafkaConfigurationProperties properties) {
    this.properties = properties;
  }

  @Bean
  KafkaSender<String, String> kafkaSender() {
    SenderOptions<String, String> options = SenderOptions.create(
        Map.of(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers(),
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer",
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer"
        )
    );
    return KafkaSender.create(options);
  }
}
