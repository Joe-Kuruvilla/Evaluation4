package com.masai.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.Entity.Email;

public interface EmailRepository extends JpaRepository<Email,Integer>{

}
