package org.oneToone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity

public class Student27 {

	@Id
	private int sid;
	
	private String sname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "laptop_id")
	private Laptop laptop;
	
	
	public int getSid() {
		return sid;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
