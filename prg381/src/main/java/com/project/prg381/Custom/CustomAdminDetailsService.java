package com.project.prg381.Custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.prg381.Admin;
import com.project.prg381.Repository.AdminRepository;

public class CustomAdminDetailsService implements UserDetailsService {

	// Get data from Admin


	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepo.findByEmail(username);
		if (admin == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomAdminDetails(admin);
	}

}