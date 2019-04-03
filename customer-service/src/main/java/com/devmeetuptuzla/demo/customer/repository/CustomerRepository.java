package com.devmeetuptuzla.demo.customer.repository;

import com.devmeetuptuzla.demo.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
