package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRoleId(Long roleId);

}
