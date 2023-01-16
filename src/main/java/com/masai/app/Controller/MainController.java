package com.masai.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<User>(ser.newUser(user), HttpStatus.CREATED); 
	}	
	
	@PostMapping("/login")
	public void login() {
		System.out.println("Logged in");
	}
	
	@GetMapping("/mail")
	public ResponseEntity<?> allFir(@Valid @PathVariable int userId) {
		return new ResponseEntity<List<Fir>>(ser.allFir(userId), HttpStatus.OK); 
	}	
	@GetMapping("/starred")
	public ResponseEntity<?> allFir(@Valid @PathVariable int userId) {
		return new ResponseEntity<List<Fir>>(ser.allFir(userId), HttpStatus.OK); 
	}	
	@PostMapping("/mail")
	public ResponseEntity<?> newUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(ser.newUser(user), HttpStatus.CREATED); 
	}	
	@PostMapping("/starred/{id}")
	public ResponseEntity<?> newUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(ser.newUser(user), HttpStatus.CREATED); 
	}	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> newUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(ser.newUser(user), HttpStatus.CREATED); 
	}	
}
