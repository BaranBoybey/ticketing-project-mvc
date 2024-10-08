package com.company.service;

import com.company.dto.ProjectDTO;
import com.company.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String>{
    void projectComplete(ProjectDTO projectDTO);
    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);
}
