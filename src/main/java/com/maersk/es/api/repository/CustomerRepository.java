package com.maersk.es.api.repository;

import java.util.List;

import com.maersk.es.api.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CustomerRepository extends ReactiveElasticsearchRepository<Customer, String> {
    Mono<Customer> findByFirstname(String firstName);

}
