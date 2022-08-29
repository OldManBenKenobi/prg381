package com.project.prg381;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin") //Creates admin table.
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true, length = 50) // set column rules in database
	private String email;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;

    @Column(name = "contact", nullable = false, length = 15)
	private String contact;

	public Long getId() { // get and set for admin table
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getContact(){
        return contact;
    }
	
    public void setContact(String contact){
        this.contact = contact;
    }

}