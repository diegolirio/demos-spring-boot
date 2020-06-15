package to.dev.diegolirio.webflux.customer.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import to.dev.diegolirio.webflux.customer.application.CustomerService;
import to.dev.diegolirio.webflux.customer.domain.Customer;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerService service;

    @GetMapping
    public Flux<Customer> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getById(@PathVariable String id) {
        return this.service.getById(id);
    }

    @GetMapping(value="/stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Customer>> getAllStream() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Customer> all = this.service.getAll();
        System.out.println("------- Stream ----------");
        return Flux.zip(interval, all);
    }
    
}
