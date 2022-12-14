package com.maersk.es.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@SpringBootApplication
//@EnableReactiveElasticsearchRepositories
public class SpringBootElasticsearchExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticsearchExampleApplication.class, args);
	}

}
