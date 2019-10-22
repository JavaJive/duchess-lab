package com.example.reactive.kafkaproducer.adapter.rest;

import com.example.reactive.kafkaproducer.adapter.kafka.MessageProducer;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value="/publish")
    public Mono<String> publishMessage(){
        String message = "“I think the best piece of advice I can give to anyone with a dream is to never be afraid to share your dreams" +
                " and talk about what you wish to create and see in the world. It’s often hard to share those pipedreams at the risk that " +
                "they might not work out, but you never know who has the collaborations, networks, and visions to make your dreams a reality." +
                " So be careful and vigilant and protect yourself intelligently of course, but never be afraid to ask for help.”";

        return Mono.just(message)
                .doOnNext(ignored -> LOG.info("Sending message={}", message))
                .flatMap(producer::publishMessageSentEvent)
                .thenReturn(message);
    }

}
