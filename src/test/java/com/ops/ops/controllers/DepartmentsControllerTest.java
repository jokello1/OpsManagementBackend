package com.ops.ops.controllers;

import com.ops.ops.dto.Departments;
import com.ops.ops.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentsController.class)
class DepartmentsControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private DepartmentService departmentService;
    @BeforeEach
    void setUp(){
        Departments departments = new Departments();
        departments.setId(1);
        departments.setName("finance");
        departments.setDescription("great department..");
        departmentService.createDepartment(departments);
    }
    @Test
    void getAllDepartments() {

        assertNull(departmentService.getAllDepartments());

    }

    @Test
    void getDepartmentById() {
        assertNull(departmentService.getDepartmentById(1));
    }

    @Test
    void createDepartment() {
    }

    @Test
    void updateDepartmentById() {
        Departments departments = new Departments();
        departments.setCreationDate(new Date());
        departments.setName("Engineering");
        departments.setDescription("Greatest department, busy and all..");
        assertNotNull(departmentService.updateDepartmentById(departments.getId(),departments));
    }

    @Test
    void deleteDepartmentById() {
    }
}