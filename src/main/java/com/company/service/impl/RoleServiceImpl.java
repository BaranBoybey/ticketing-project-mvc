package com.company.service.impl;

import com.company.dto.RoleDTO;
import com.company.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO user) {
        return super.save(user, user.getId());
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(), object);
    }
}
