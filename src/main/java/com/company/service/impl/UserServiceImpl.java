package com.company.service.impl;

import com.company.dto.UserDTO;
import com.company.service.CrudService;
import com.company.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {

    @Override
    public UserDTO save(UserDTO user) {
        return super.save(user,user.getUserName());
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream().filter(userDTO -> userDTO.getRole().getId() == 2).collect(Collectors.toList());
    }
}
