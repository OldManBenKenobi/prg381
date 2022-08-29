package com.project.prg381;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Register") //makes table register (Not used)
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "student", nullable = false, unique = true, length = 45)
	private String student;

    @Column(name = "cource", nullable = false, length = 20)
	private String cource;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "student", referencedColumnName = "id")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudent() {
		return student;
	}

	public void setEmail(String student) {
		this.student = student;
	}
	
	public String getCource() {
		return cource;
	}

	public void setCource(String cource) {
		this.cource = cource;
	}
	
}