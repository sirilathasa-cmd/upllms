package com.upl.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upl.www.model.User;
import com.upl.www.service.UserService;

@RestController
@RequestMapping("/instructors")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		 
		Authentication authentication = authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(user.getEmail(),
						user.getPassword()
						)
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return ResponseEntity.ok("Login Successful");
	}
}
