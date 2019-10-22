package com.example.reactive.kafkaproducer.adapter.rest;

import com.example.reactive.kafkaproducer.adapter.kafka.MessageProducer;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.slf4j.LoggerFactory.getLogger;


@RestController
public class PublishMessageController {

    private static final Logger LOG = getLogger(PublishMessageController.class);

    private final MessageProducer producer;

    public PublishMessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value="/publish/{message}")
    public Mono<String> publishMessage(@PathVariable String message){
        return Mono.just(message)
                .doOnNext(ignored -> LOG.info("Sending message={}", message))
                .flatMap(producer::publishMessageSentEvent)
                .thenReturn(message);
    }

}
