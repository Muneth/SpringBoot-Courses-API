package com.coursesapp.coursesappadmin.service;

import com.coursesapp.coursesappadmin.entity.User;

public interface UserService {

    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
