package com.example.hangzhao.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by hangzhao on 7/10/16.
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

}
