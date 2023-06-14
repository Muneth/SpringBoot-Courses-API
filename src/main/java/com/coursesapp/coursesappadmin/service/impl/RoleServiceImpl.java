package com.coursesapp.coursesappadmin.service.impl;

import com.coursesapp.coursesappadmin.daoOrRepository.RoleDao;
import com.coursesapp.coursesappadmin.entity.Role;
import com.coursesapp.coursesappadmin.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role createRole(String roleName) {
        return roleDao.save(new Role(roleName));
    }
}
