package com.example.testSecurity.user.service;

import com.example.testSecurity.role.domain.Role;
import com.example.testSecurity.user.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();

}
