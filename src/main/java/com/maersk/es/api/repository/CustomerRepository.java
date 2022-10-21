package com.maersk.es.api.repository;

import java.util.List;

import com.maersk.es.api.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    List<Customer> findByFirstname(String firstName);

}
