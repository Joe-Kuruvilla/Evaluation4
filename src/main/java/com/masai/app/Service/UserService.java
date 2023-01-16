package com.masai.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.Entity.Email;
import com.masai.app.Entity.User;
import com.masai.app.Repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository rep;
	
	public User registerUser(User user) {
		return rep.save(user);
	}
	
	public List<Email> getAllMail(int emailid) {
		return rep.findEmail(emailid);
	}
	
	public User newFir(int id,Fir fir) {
		User user=rep.findById(id).get();
		user.getFir().add(fir);
		fir.setUser(user);
		return rep.save(user);
	}
	
}
