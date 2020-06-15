package com.diegolirio.demospringdataspecifications.api;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolirio.demospringdataspecifications.customer.Customer;
import com.diegolirio.demospringdataspecifications.customer.CustomerRepository;
import com.diegolirio.demospringdataspecifications.customer.CustomerSpecification;
import com.diegolirio.demospringdataspecifications.dto.SearchCriteria;

@RestController
public class CustomerApi {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Customer> getAll() {
		return this.customerRepository.findAll();
	}
	
	@PostMapping
	public void post() {
		for (int i = 0; i <= 10 ; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.YEAR, -i);
			this.customerRepository.save(
						Customer.builder().firstname("Diego_"+i).lastname("Lirio_"+i).age(i).created(calendar.getTime()).build()
					);	
		}
	}
	
	@GetMapping("/search")
	public List<Customer> getByFilter() {
	    CustomerSpecification spec1 = new CustomerSpecification(new SearchCriteria("lastname", ":", "Lirio_7"));
	    CustomerSpecification spec2 = new CustomerSpecification(new SearchCriteria("firstname", ":", "Diego_5"));
	    
		//Calendar calendar = Calendar.getInstance();
		//calendar.set(Calendar.YEAR, 2012);
	    //CustomerSpecification spec3 = new CustomerSpecification(new SearchCriteria("created", ">", calendar.getTime()));
	    
	    CustomerSpecification spec3 = new CustomerSpecification(new SearchCriteria("age", ">", 6));
	    
	    
	    Specifications<Customer> specifications = Specifications.where(spec1).and(spec3).or(spec2);
	    return customerRepository.findAll(specifications);
	}
		
}
