package com.example.testSecurity.user.repo;

import com.example.testSecurity.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
