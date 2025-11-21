package com.transportsecure.repository;

import com.transportsecure.entity.Package;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageRepository extends MongoRepository<Package, String> {
}
