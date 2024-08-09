package org.manyTomany;

import jakarta.persistence.Entity;

@Entity
public class Practical extends Subject{

	private int practicalMarks;

	public int getPracticalMarks() {
		return practicalMarks;
	}

	public void setPracticalMarks(int practicalMarks) {
		this.practicalMarks = practicalMarks;
	}
	
}
