package com.maxxi.maxxi.repository;


import com.maxxi.maxxi.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String rolename);
}
