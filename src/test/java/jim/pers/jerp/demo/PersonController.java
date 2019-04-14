package jim.pers.jerp.demo;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@RestController
public class PersonController {

    @PostMapping("/person")
    Mono<Void> create(@RequestBody Publisher<Person> personStream) {
        personStream.subscribe(new Subscriber<Person>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(Person person) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
        return Mono.empty();
    }

    @GetMapping("/person")
    Flux<Person> list() {
        Person[] persons = {new Person(1,"Jim"),new Person(2,"Allan")};

       return   Flux.create( sink  ->{
          try {
              sink.next(new Person(1,"Jim"));
              TimeUnit.SECONDS.sleep(3);
              sink.next(new Person(2,"Allan"));
              TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              sink.complete();
          }
        }, FluxSink.OverflowStrategy.DROP);
    }

    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable String id) {
        return Mono.just(new Person(1,"Jim"));
    }
}