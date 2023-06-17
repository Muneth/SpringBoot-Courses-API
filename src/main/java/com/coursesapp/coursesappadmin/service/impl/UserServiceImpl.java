package com.coursesapp.coursesappadmin.service.impl;

import com.coursesapp.coursesappadmin.daoOrRepository.RoleDao;
import com.coursesapp.coursesappadmin.daoOrRepository.UserDao;
import com.coursesapp.coursesappadmin.entity.Role;
import com.coursesapp.coursesappadmin.entity.User;
import com.coursesapp.coursesappadmin.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDao roleDao;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

//    This method is used by the UserDetailsServiceImpl class to load a user by email address to authenticate the user during login
    @Override
    public User loadUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

//    Create a user and encode the password before saving it to the database
    @Override
    public User createUser(String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        return userDao.save(new User(email, encodedPassword));
    }

//    Assign a role to a user by email address and role name
    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = loadUserByEmail(email);
        Role role = roleDao.findByName(roleName);
        user.assignRoleToUser(role);
    }
}
