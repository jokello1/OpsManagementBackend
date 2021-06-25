package com.ops.ops.services;

import com.ops.ops.dto.Departments;
import com.ops.ops.exceptions.ResourceNotFoundException;
import com.ops.ops.repositories.DepartmentRepository;
import com.ops.ops.responses.DepartmentSignupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<List<Departments>> getAllDepartments() {
        return ResponseEntity.ok(departmentRepository.findAll()) ;
    }
    public ResponseEntity<Departments> getDepartmentById(int id) {
        return ResponseEntity.ok(departmentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User not found..")
        )) ;
    }
    public ResponseEntity<String> deleteDepartmentById(int id) {
        Departments departments = departmentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User does not exist.."));
            if (departments!=null)
                departmentRepository.delete(departments);
                return ResponseEntity.ok().build();
    }
    public ResponseEntity<Departments> updateDepartmentById(int id,Departments department) {
        return departmentRepository.findById(id)
                .map(departments1->{
                    departments1.setDescription(department.getDescription());
                    departments1.setCreationDate(department.getCreationDate());
                    departments1.setName(department.getName());
                    return ResponseEntity.ok( this.departmentRepository.save(departments1));
                }).orElseThrow(
                ()->new ResourceNotFoundException("User does not exist..")
        );
    }
    public ResponseEntity<DepartmentSignupResponse> createDepartment(Departments departments) {
        Optional<Departments> optionalDepartments = departmentRepository.findByName(departments.getName());
        DepartmentSignupResponse signupResponse = new DepartmentSignupResponse();
        if (optionalDepartments.isPresent()){
            signupResponse.setDepartment(optionalDepartments.get());
            signupResponse.setMessage("Department already exists..");
            return ResponseEntity.ok(signupResponse);
        }
        departments.setCreationDate(new Date());
        signupResponse.setDepartment(departmentRepository.save(departments));
        signupResponse.setMessage("Creation successful");
        return ResponseEntity.ok(signupResponse);
    }
}
