package jim.pers.jerp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Configuration
public class HomeHandler {
    public Mono<ServerResponse> home(ServerRequest serverRequest) {
        String TargetUrl = "static/login.html";
        return ServerResponse.temporaryRedirect(URI.create(TargetUrl)).build();
    }
}
