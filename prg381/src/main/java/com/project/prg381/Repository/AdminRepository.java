package com.project.prg381.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.prg381.Admin;

//Get all from Admin 

public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query("SELECT u FROM Admin u WHERE u.email = ?1")
	public Admin findByEmail(String email);
	
}
