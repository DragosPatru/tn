package com.tuneride.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tuneride.server.domain.TunerideUser;

public interface UserRepository extends CrudRepository<TunerideUser, Long> {
	TunerideUser findByUsername(String username);
}
