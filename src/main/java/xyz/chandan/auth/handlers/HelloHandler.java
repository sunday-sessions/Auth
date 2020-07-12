package xyz.chandan.auth.handlers;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {
    public Mono<String> handle() {
        return Mono.just("hello world");
    }
}
