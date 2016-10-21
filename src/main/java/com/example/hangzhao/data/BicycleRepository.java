package com.example.hangzhao.data;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by hangzhao on 7/10/16.
 */
public interface BicycleRepository extends MongoRepository<Bicycle,String> {
}
