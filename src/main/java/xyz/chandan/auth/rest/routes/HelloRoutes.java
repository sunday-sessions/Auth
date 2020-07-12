package xyz.chandan.auth.rest.routes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
import xyz.chandan.auth.handlers.HelloHandler;

@Configuration
public class HelloRoutes {

    @Autowired
    private HelloHandler handler;

    @Bean(name = "hello-router")
    public RouterFunction<ServerResponse> router() {
        return RouterFunctions.route(
                RequestPredicates.GET("/v1/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                this::route);
    }

    private Mono<ServerResponse> route(ServerRequest request) {
        return register(request)
                .flatMap(rp -> ServerResponse.ok().body(Mono.just(rp), String.class));
    }

    private Mono<String> register(ServerRequest request) {

        return handler.handle();
    }
}