package com.project.prg381;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student") //creates user table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true, length = 50) // sets values for columns
	private String email;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Column(name = "name", nullable = false, length = 40)
	private String name;
	
	@Column(name = "address", nullable = false, length = 20)
	private String address;

    @Column(name = "cource", nullable = false, length = 20)
	private String cource;

	public Long getId() { // get and set for users 
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    public String getCource(){
        return cource;
    }
	
    public void setCource(String cource){
        this.cource = cource;
    }

}