package org.oneToone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student2")
public class Student1 {
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;  
	  @Column
	 private String name;
	 
	 
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
	 
	 

}