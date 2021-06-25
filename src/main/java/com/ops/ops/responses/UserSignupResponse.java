package com.ops.ops.responses;

import com.ops.ops.dto.Departments;
import com.ops.ops.dto.Users;
import lombok.Data;

@Data
public class UserSignupResponse {
    private Users users;
    private String message;
}
