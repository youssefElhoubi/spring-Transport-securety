package com.transportsecure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface User extends MongoRepository<User, String> {
}
