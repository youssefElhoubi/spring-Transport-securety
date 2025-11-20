package com.transportsecure.repository;

import com.transportsecure.entity.User;
import com.transportsecure.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);

    Page<User> findAllByRole(Role role, Pageable pageable);
}
