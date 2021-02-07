package com.example.webfluxdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/4
 */
@RequestMapping("/api/")
@RestController
@Slf4j
public class HelloController {

    @GetMapping("mono")
    public Mono<Object> mono() {
        return Mono.create(monoSink -> {
            log.info("创建 Mono");
            monoSink.success("hello webflux");
        }).doOnSubscribe(subscription -> {
            log.info("doOnSubscribe{}", subscription);
        }).doOnNext(o -> {
            log.info("doOnNext{}", o);
        });
    }

    @GetMapping("flux")
    public Flux<ServerSentEvent<Integer>> flux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                .map(data -> ServerSentEvent.<Integer>builder()
                        .event("random")
                        .id(Long.toString(data.getT1()))
                        .data(data.getT2())
                        .build());
    }



}
