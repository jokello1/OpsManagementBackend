package com.ops.ops.controllers;

import com.ops.ops.dto.Departments;
import com.ops.ops.responses.DepartmentSignupResponse;
import com.ops.ops.responses.UserSignupResponse;
import com.ops.ops.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("departments")
public class DepartmentsController {
    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Departments>> getAllDepartments(){
        return  departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Departments> getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }
    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentSignupResponse> createDepartment(@RequestBody Departments departments){
        return departmentService.createDepartment(departments);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Departments> updateDepartmentById(@PathVariable int id,@RequestBody Departments departments){
        return departmentService.updateDepartmentById(id,departments);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable int id){
        return departmentService.deleteDepartmentById(id);
    }
}
