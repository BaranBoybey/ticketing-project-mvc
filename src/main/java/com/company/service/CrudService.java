package com.company.service;

import com.company.dto.RoleDTO;
import com.company.dto.UserDTO;

import java.util.List;

public interface CrudService<T,ID> {

    T save(T user);

    T findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}
