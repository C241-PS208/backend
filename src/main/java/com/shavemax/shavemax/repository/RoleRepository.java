package com.shavemax.shavemax.repository;

import com.shavemax.shavemax.entity.Role;
import com.shavemax.shavemax.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(RoleEnum name);
}
