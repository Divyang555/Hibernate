package org.oneTomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {

	@Id
	private int t_id;
	
	private String t_name;

	@OneToMany
	private List<Address> addlist;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public List<Address> getAddlist() {
		return addlist;
	}

	public void setAddlist(List<Address> addlist) {
		this.addlist = addlist;
	}
	
	
	

	
	
}
