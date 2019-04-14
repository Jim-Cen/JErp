package jim.pers.jerp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    @GetMapping("/")
    public Mono<Person> hello() {
        return Mono.just(new Person(1,"Jim"));
    }
}