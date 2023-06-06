package com.coursesapp.coursesappadmin.daoOrRepository;

import com.coursesapp.coursesappadmin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
