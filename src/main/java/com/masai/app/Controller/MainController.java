package com.masai.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Entity.Email;
import com.masai.app.Entity.User;
import com.masai.app.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaimail")
public class MainController {
	@Autowired
	UserService ser;
	
	@PostMapping("/register")
	public ResponseEntity<?> newUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(ser.registerUser(user), HttpStatus.CREATED); 
	}	
	
	@PostMapping("/login")
	public void login() {
		System.out.println("Logged in");
	}
	
	@GetMapping("/mail/{userId}")
	public List<Email> displayInbox(int userId)
	{
		return ser.displayAllMails(userId);
	}
	@GetMapping("/starmail/{userId}")
	public List<Email> displayStarInbox(int userId)
	{
		return ser.displayStarMails(userId);
	}
	
	@PostMapping("/mail/{userId}")
	public boolean addNewMailInInbox(int userId, @RequestBody Email email)
	{
		ser.sentMail(userId, email);
		return true;
	}	
	@PostMapping("/starmail/{userId}")
	public boolean addNewStarMailInInbox(int userId, @RequestBody Email email)
	{
		ser.sentMail(userId, email);
		return true;
	}	
	@PostMapping("/deletemail/{userId}/{emailId}")
	public boolean deleteMailInInbox(int userId, int emailId)
	{
		ser.deleteMail(userId, emailId);
		return true;
	}		
}
