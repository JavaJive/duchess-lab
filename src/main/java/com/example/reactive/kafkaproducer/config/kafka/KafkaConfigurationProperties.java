package com.example.reactive.kafkaproducer.config.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaConfigurationProperties {

  private String bootstrapServers;
}
