package com.project.prg381.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.project.prg381.User;

//Allows web pages to get data from database

public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(long id);
	void deleteUserById(long id);
	Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}