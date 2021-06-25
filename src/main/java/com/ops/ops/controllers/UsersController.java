package com.ops.ops.controllers;

import com.ops.ops.dto.Departments;
import com.ops.ops.dto.Users;
import com.ops.ops.responses.DepartmentSignupResponse;
import com.ops.ops.responses.UserSignupResponse;
import com.ops.ops.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        return  userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<List<Users>> getUserByDepartmentId(@PathVariable int id){
        return userService.getUserByDepartmentId(id);
    }
    @PostMapping("/createUser")
    public ResponseEntity<UserSignupResponse> createUser(@RequestBody Users user){
        return userService.createUser(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable int id,@RequestBody Users users){
        return userService.updateUserById(id,users);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id){
        return userService.deleteUserById(id);
    }
}
