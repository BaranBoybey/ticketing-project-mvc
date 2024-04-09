package com.company.service.impl;

import com.company.dto.ProjectDTO;
import com.company.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO user) {
        return super.save(user, user.getProjectCode());
    }

    @Override
    public ProjectDTO findById(String s) {
        return super.findById(s);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(),object);

    }
}
