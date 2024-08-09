package org.manyTomany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Team {
	
	@Id
	private int id;
	@Column
	private String name;
	
	@ManyToMany(mappedBy = "tlist")
	private List<Player> plist;

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

	public List<Player> getPlist() {
		return plist;
	}

	public void setPlist(List<Player> plist) {
		this.plist = plist;
	}
	
	

}
