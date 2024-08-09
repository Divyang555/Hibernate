package org.manyTomany;

import jakarta.persistence.Entity;

@Entity
public class RetiredStaff extends Staff {

	private int s_pension;

	public int getS_pension() {
		return s_pension;
	}

	public void setS_pension(int s_pension) {
		this.s_pension = s_pension;
	}
}
