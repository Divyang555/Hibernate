package org.oneTomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	private int trainid;
	
	private String trainname;
	
	@OneToMany(mappedBy = "trainer")
	private List<Trainee> traineelist;

	public List<Trainee> getTraineelist() {
		return traineelist;
	}

	public void setTraineelist(List<Trainee> traineelist) {
		this.traineelist = traineelist;
	}

	public int getTrainid() {
		return trainid;
	}

	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	
	
}
