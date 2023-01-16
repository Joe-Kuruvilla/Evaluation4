package com.masai.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.Entity.Email;
import com.masai.app.Entity.User;

public interface UserRepository extends JpaRepository<User, String> {
//	@Query("Select fir from User where userId=?1")
//	public List<Email> findFir(int id);
	
	@Query("Select emails from Email where emailId=?1")
	public List<Email> findEmail(int id);
}
