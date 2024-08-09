package org.oneToone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Library1")
public class Library {
	
	    @Id
	    //@GeneratedValue(strategy = GenerationType.AUTO)
	 	private int b_id;
	    @Column
	 	private String b_name;
	    
	    @OneToOne(cascade = CascadeType.PERSIST)
	    @JoinColumn(name = "stid", referencedColumnName = "id")
	    private Student1 student1;
		
		public Student1 getStudent1() {
			return student1;
		}
		public void setStudent1(Student1 student1) {
			this.student1 = student1;
		}
		public int getB_id() {
			return b_id;
		}
		public void setB_id(int b_id) {
			this.b_id = b_id;
		}
		public String getB_name() {
			return b_name;
		}
		public void setB_name(String b_name) {
			this.b_name = b_name;
		}
	    
	    
	 	
	

}
