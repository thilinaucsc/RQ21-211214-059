package com.example.genarateinterest.repository;

import com.example.genarateinterest.dto.enm.RoleName;
import com.example.genarateinterest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName roleName);
}
