package com.masai.app.Service;

import java.util.ArrayList;
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
	
	public List<Email> displayAllMails(int id)
	{
		return rep.findEmails(id);
	}
	
	public List<Email> displayStarMails(int id)
	{
		return rep.findStarEmails(id);
	}
	
	@SuppressWarnings("deprecation")
	public boolean sentMail(int id, Email email)
	{
		rep.getById(id).getInbox().add(email);
		return true;
	}
	@SuppressWarnings("deprecation")
	public boolean starredMail(int id, Email email)
	{
		rep.getById(id).getStarred().add(email);
		return true;
	}
	@SuppressWarnings("deprecation")
	public boolean deleteMail(int userId, int emailId)
	{
		rep.getById(userId).getInbox().remove(emailId);
		rep.getById(userId).getStarred().remove(emailId);
		return true;
	}
	
}
