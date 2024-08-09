package org.manyTomany;

import jakarta.persistence.Entity;

@Entity
public class Theory extends Subject{

	private int theorymarks;

	public int getTheorymarks() {
		return theorymarks;
	}

	public void setTheorymarks(int theorymarks) {
		this.theorymarks = theorymarks;
	}

	
}
