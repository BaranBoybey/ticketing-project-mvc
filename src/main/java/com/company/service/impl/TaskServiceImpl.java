package com.company.service.impl;

import com.company.dto.TaskDTO;
import com.company.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO user) {
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
        deleteById(id);
    }

    @Override
    public void update(TaskDTO object) {
        super.update(object.getId(),object);
    }
}