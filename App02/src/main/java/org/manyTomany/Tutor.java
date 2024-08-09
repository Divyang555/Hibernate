package org.manyTomany;

import jakarta.persistence.Entity;

@Entity
public class Tutor extends Human{

	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
