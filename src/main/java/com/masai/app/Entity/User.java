package com.masai.app.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@Id
	@GeneratedValue
	private String email;
	@Pattern(regexp="^[A-Z][a-z]*",message = "{firstName.invalid}")
	private String firstName;
	@Pattern(regexp="^[A-Z][a-z]*",message = "{lastName.invalid}")
	private String lastName;
	@Size(min=10,max=10,message = "{mobileNumber.invalid}")
	private String mobileNo;
	@Past
	private LocalDate dateOfBirth;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Email> emails=new ArrayList<>();
}
