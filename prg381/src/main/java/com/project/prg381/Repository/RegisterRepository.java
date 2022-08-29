package com.project.prg381.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.prg381.Register;

//Get all from register (Broken)

public interface RegisterRepository extends JpaRepository<Register, Long> 
{

    //@Query("SELECT * FROM Register WHERE student = ?1")
    public Register findByStudent(String id);
    
}