package org.manyTomany;

import jakarta.persistence.Entity;

@Entity
public class Pupil extends Human{

	
	private int fee;

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
}
