package com.ops.ops.repositories;

import com.ops.ops.dto.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
    Optional<Departments> findByName(String name);
}
