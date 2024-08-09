package org.manyTomany;

import jakarta.persistence.Entity;

@Entity
public class ActiveStaff extends Staff {

	private int S_salary;
	
	private int S_experience;

	public int getS_salary() {
		return S_salary;
	}

	public void setS_salary(int s_salary) {
		S_salary = s_salary;
	}

	public int getS_experience() {
		return S_experience;
	}

	public void setS_experience(int s_experience) {
		S_experience = s_experience;
	}
	
	
}
