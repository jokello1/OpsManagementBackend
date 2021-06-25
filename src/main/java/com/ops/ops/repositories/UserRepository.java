package com.ops.ops.repositories;

import com.ops.ops.dto.Departments;
import com.ops.ops.dto.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByPhone(String phone);
}
