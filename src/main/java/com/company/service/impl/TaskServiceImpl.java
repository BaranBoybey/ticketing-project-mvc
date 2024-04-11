package com.company.service.impl;

import com.company.dto.TaskDTO;
import com.company.dto.UserDTO;
import com.company.enums.Status;
import com.company.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO user) {
        if (user.getTaskStatus()==null){
            user.setTaskStatus(Status.OPEN);
        }

        if (user.getAssignedDate()==null){
            user.setAssignedDate(LocalDate.now());
        }
        return super.save(user,user.getId());
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO object) {
        if (object.getTaskStatus()==null){
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignedDate()==null){
            object.setAssignedDate(LocalDate.now());
        }
        super.update(object.getId(),object);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {

        return findAll().stream().filter(taskDTO -> taskDTO.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }
}