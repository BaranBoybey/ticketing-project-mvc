package com.company.entity;

import com.company.dto.UserDTO;

import java.time.LocalDate;

public class Project extends BaseEntity{
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetails;
}
