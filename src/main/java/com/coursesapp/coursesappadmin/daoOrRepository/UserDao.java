package com.coursesapp.coursesappadmin.daoOrRepository;

import com.coursesapp.coursesappadmin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
