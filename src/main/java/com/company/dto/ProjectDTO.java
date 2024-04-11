package com.company.dto;

import com.company.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public ProjectDTO(String projectName, String projectCode, UserDTO assignedManager, LocalDate startDate, LocalDate endDate, String projectDetails, Status status) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetails = projectDetails;
        this.status = status;
    }

    private String projectDetails;
    private Status status;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;

}
