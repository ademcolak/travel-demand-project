package com.travel.project.service;

import com.travel.project.controller.model.request.CrmUser;
import com.travel.project.entity.Role;
import com.travel.project.entity.User;
import com.travel.project.repository.RoleRepository;
import com.travel.project.repository.UserRepository;
import com.travel.project.service.base.UserService;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


	private final UserRepository userRepository;

	private final RoleRepository roleRepository;
	
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public Optional<User> findByUserName(String userName) {
		// check the database if the user already exists
		return userRepository.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));


		roleRepository.findByName("ROLE_EMPLOYEE")
				.ifPresent(role -> {
					user.setRoles(Arrays.asList(role));
				});
		// give user default role of "employee"

		 // save user in the database
		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return userRepository.findByUserName(userName)
				.map(user-> new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
						mapRolesToAuthorities(user.getRoles())))
				.orElseThrow(()->	{
					throw new UsernameNotFoundException("Invalid username or password.");
				});
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
