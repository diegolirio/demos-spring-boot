package to.dev.diegolirio.webflux.customer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import to.dev.diegolirio.webflux.customer.domain.Customer;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

}
