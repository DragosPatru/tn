package com.tuneride.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuneride.server.domain.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Long> {

}
