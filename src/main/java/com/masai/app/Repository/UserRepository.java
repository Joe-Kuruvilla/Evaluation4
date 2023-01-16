package com.masai.app.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.app.Entity.Email;
import com.masai.app.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	@Query("Select inbox from User where userId=?1")
	public List<Email> findEmails(int id);
	
	@Query("Select starred from User where userId=?1")
	public List<Email> findStarEmails(int id);
}
