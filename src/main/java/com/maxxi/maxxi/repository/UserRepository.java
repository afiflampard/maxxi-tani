package com.maxxi.maxxi.repository;
import com.maxxi.maxxi.models.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
