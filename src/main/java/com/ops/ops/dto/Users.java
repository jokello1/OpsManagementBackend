package com.ops.ops.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dateOfBirth;
    private String phone;
    private String email;
    private String profession;
    private Date creationDate;
    private int departmentId;
}
