package com.company.service;

import com.company.dto.TaskDTO;
import com.company.dto.UserDTO;
import com.company.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long>{
    List<TaskDTO> findTasksByManager(UserDTO userDTO);

    List<TaskDTO> findAllTasksStatusIsNot(Status status);

    List<TaskDTO> findAllTasksByStatus(Status status);
}
