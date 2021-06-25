package com.ops.ops.services;

import com.ops.ops.dto.Users;
import com.ops.ops.exceptions.ResourceNotFoundException;
import com.ops.ops.repositories.UserRepository;
import com.ops.ops.responses.UserSignupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        userRepository.findAll().forEach(usersList::add);
        return ResponseEntity.ok(usersList) ;
    }
    public ResponseEntity<Users> getUserById(int id) {
        return ResponseEntity.ok(userRepository.findById(id).orElseThrow()) ;
    }
    public ResponseEntity<String> deleteUserById(int id) {
        Users users= userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User does not exist.."));
        userRepository.delete(users);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<Users> updateUserById(int id,Users user) {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
           return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.badRequest().body(null) ;
    }
    public ResponseEntity<UserSignupResponse> createUser(Users user) {
        Optional<Users> optionalUsers = userRepository.findByPhone(user.getPhone());
        UserSignupResponse signupResponse = new UserSignupResponse();
        if (optionalUsers.isPresent()){
            signupResponse.setUsers(optionalUsers.get());
            signupResponse.setMessage("User already exists..");
            return ResponseEntity.ok(signupResponse);
        }
        user.setCreationDate(new Date());
        signupResponse.setUsers(userRepository.save(user));
        signupResponse.setMessage("Creation successful");
        return ResponseEntity.ok(signupResponse);
    }

    public ResponseEntity<List<Users>> getUserByDepartmentId(int id) {
        List<Users> usersList = new ArrayList<>();
                userRepository.findAll().forEach(users -> {
                    if (users.getDepartmentId() == id) {
                        usersList.add(users);
                    }
                });
                return ResponseEntity.ok(usersList);
    }
}
