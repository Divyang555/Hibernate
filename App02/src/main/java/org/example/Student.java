package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Student1")
public class Student {


	private int id;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String name;
	
	private String address;


	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		
		return "Id:"+id+" "+"Name:"+name+"  "+"Address:"+address;
	}
	
	
}
