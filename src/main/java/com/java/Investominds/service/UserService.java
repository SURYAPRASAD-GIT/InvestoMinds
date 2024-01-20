package com.java.Investominds.service;

import com.java.Investominds.model.User;
import com.java.Investominds.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
