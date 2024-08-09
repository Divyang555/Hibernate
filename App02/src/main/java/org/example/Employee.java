package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Emp1")
public class Employee {

	@Id
	@GeneratedValue
	private String email;
	@Column(name="pass")
    private String password;
    
    
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		password = password;
	}
    

}
