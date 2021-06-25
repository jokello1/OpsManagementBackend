package com.ops.ops.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table
public class Departments {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date creationDate;
}
