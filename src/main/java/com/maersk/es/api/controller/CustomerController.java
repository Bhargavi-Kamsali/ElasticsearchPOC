package com.maersk.es.api.controller;

import com.maersk.es.api.model.Customer;
import com.maersk.es.api.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        List<Customer> customers=getCustomers();
        Customer customer=customers.stream().
                filter(c->c.getId().equalsIgnoreCase(id)).findAny().orElse(null);
        if(customer!=null){
            logger.info("Customer  found : {}",customer);
            return customer;
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Customer Not Found with ID : {}",id);
            }
            return new Customer();
        }
    }

    private List<Customer> getCustomers() {
        return Stream.of(new Customer("1", "John","Roy",25),
                        new Customer("2", "Shyam","Singh",30),
                        new Customer("3", "Rony","Kunal",22),
                        new Customer("4", "Lokesh","Achari",19))
                .collect(Collectors.toList());
    }

    @PostMapping("/saveCustomer")
    public Flux<Customer> saveCustomer(@RequestBody Iterable<Customer> customers){
        Flux<Customer> custs=customerRepository.saveAll(customers);
        logger.info("Customers saved into ES}");
        return custs;
    }

    @GetMapping("/findAll")
    public Flux<Customer> findAllCustomers(){
        logger.info("Displaying all saved  customers list}");
        return  customerRepository.findAll();
    }

    @GetMapping("/findAll/{firstName}")
    public Mono<Customer> findByFirstName(@PathVariable String firstName){
        return  customerRepository.findByFirstname(firstName);
    }

}
