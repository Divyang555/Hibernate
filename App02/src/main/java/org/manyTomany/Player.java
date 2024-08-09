package org.manyTomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Player {
	
	@Id
	private int id;
	@Column
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Team> tlist;
	
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
	public List<Team> getTlist() {
		return tlist;
	}
	public void setTlist(List<Team> tlist) {
		this.tlist = tlist;
	}
	
	

}
