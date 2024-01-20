package com.java.Investominds.service;

import com.java.Investominds.model.Role;
import com.java.Investominds.model.User;
import com.java.Investominds.repository.UserRepository;
import com.java.Investominds.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),registrationDto.getLoginid(),
				passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getPhone(),registrationDto.getAddress() ,Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByLoginid(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new LoginUser(user);
	}



}






























/*return new org.springframework.security.core.userdetails.User(user.getLoginid() ,user.getPassword(), mapRolesToAuthorities(user.getRoles()));*/


/*
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
*/
