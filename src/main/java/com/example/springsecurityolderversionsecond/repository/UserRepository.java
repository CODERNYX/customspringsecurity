package com.example.springsecurityolderversionsecond.repository;

import com.example.springsecurityolderversionsecond.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
