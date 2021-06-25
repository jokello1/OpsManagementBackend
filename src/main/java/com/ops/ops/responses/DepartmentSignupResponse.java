package com.ops.ops.responses;

import com.ops.ops.dto.Departments;
import lombok.Data;

@Data
public class DepartmentSignupResponse {
    private Departments department;
    private String message;
}
