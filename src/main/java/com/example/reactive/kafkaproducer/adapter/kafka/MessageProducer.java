package com.example.reactive.kafkaproducer.adapter.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import reactor.kafka.sender.SenderResult;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MessageProducer {

  private final KafkaSender<String, String> kafkaSender;
  private static final Integer UNSPECIFIED_PARTITION = null;
  private static final String UNSPECIFIED_KEY = null;

  private static final String TOPIC = "msg-sent";

  public MessageProducer(KafkaSender<String, String> kafkaSender) {
    this.kafkaSender = kafkaSender;
  }


  /**
   * Perhaps here we can mention stuff for Kafka and connect them with the code. Question like , interaction.
   */
  public Mono<String> publishMessageSentEvent(String message) {
    final var record = createProducerRecord(message);
    final var senderRecordMono = Mono.just(SenderRecord.create(record, "test"));

      /**
       * TODO What happens if send fails?
       */
    return kafkaSender.send(senderRecordMono)
        .map(SenderResult::correlationMetadata)
        .next();
  }

  private ProducerRecord<String, String> createProducerRecord(String message) {
    return new ProducerRecord<>(TOPIC, UNSPECIFIED_PARTITION, UNSPECIFIED_KEY, message);
  }
}
