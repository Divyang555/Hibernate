package org.oneTomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Student3")
public class Student2 {
	
    @Id
	private int Id; 	
	
	private String Name;
	
	@OneToMany( targetEntity = Book.class)
	private List book;

	public List getBook() {
		return book;
	}

	public void setBook(List book) {
		this.book = book;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


	
	
	
	

}
