package org.oneTomany;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emp {

	@Id
	private int e_id;
	
	private String e_name;	

	@ManyToOne
	@JoinColumn(name="comid", referencedColumnName = "c_id")
	private Company company;
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name2) {
		this.e_name = e_name2;
	}
	
	
	
	
}
