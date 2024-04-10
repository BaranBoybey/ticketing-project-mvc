package com.company.entity;

import com.company.dto.ProjectDTO;
import com.company.dto.UserDTO;
import com.company.enums.Status;

import java.time.LocalDate;

public class Task extends BaseEntity{
    private Long id;
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    private Status taskStatus;
    private LocalDate assignedDate;
}
