package com.tuneride.server.web.controller;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuneride.server.domain.TunerideUser;
import com.tuneride.server.repository.UserRepository;

// Based on : https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

@RestController
//@RequestMapping("/users")
public class UserController {

	/*@Inject
	private UserRepository userRepository;
	@Inject
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/sing-up")
	public void singUp(@RequestBody TunerideUser user) {
		// encode password
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		// save the user
		userRepository.save(user);
	}*/
}
