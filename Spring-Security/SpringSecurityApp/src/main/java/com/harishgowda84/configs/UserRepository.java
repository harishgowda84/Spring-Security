package com.harishgowda84.configs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{	
	 User findByUsername(String username);
}
