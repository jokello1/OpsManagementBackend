package com.ops.ops.services;

import com.ops.ops.dto.Departments;
import com.ops.ops.repositories.DepartmentRepository;
import com.ops.ops.responses.DepartmentSignupResponse;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private DepartmentService departmentService;
    private final DepartmentRepository departmentRepository  = Mockito.mock(DepartmentRepository.class);
    @BeforeEach
    public void setUp() {
        departmentService = new DepartmentService(departmentRepository);
        Departments departments = new Departments();
        departments.setCreationDate(new Date());
        departments.setName("Engineering");
        departments.setDescription("Greatest department, busy and all..");
        departments.setId(1);
        departmentService.createDepartment(departments);
    }

    @Test
    void getAllDepartments() {
        System.out.println(departmentService.getAllDepartments());
        assertNotNull(departmentService.getAllDepartments());
    }

    @Test
    void updateDepartmentById() {
        Departments departments = new Departments();
        departments.setCreationDate(new Date());
        departments.setName("Engineering");
        departments.setDescription("Greatest department, busy and all..");
        Departments departments1 = departmentService.createDepartment(departments).getBody().getDepartment();
        assertNotNull(departmentService.getDepartmentById(departments1.getId()));
    }

    @Test
    void createDepartment() {
        Departments departments = new Departments();
        departments.setCreationDate(new Date());
        departments.setName("Health");
        departments.setDescription("Greatest department, busy and all..");
        assertNotNull(departmentService.createDepartment(departments));
    }
}