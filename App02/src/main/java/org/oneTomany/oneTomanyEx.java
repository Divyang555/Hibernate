package org.oneTomany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class oneTomanyEx {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		int choice,e_id,c_id,value;
		String e_name,c_name;
		
		List<Emp> elist =null;
		List<Company> clist=null;
		Emp emp= null;
		Company company= null;
		EntityManager em=null;
		EntityManagerFactory emf=null;
		EntityTransaction et=null;
		
		emf=Persistence.createEntityManagerFactory("persistence");
		em=emf.createEntityManager();
		et=em.getTransaction();
		
		do
		{
			System.out.println("1.Insert Record from company side.");
			System.out.println("2.Print Record.");
			System.out.println("3.Insert Record From Emp side.");
			
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
			    case 1:
			    {
			    	company = new Company();
			    	
			    	System.out.println("Enter a company id:");
			    	c_id=sc.nextInt();
			    	
			    	System.out.println("Enter a company name:");
			    	c_name=sc.next();
			    	
			    	company.setC_id(c_id);
			    	company.setC_name(c_name);
			    	
			    	
			    	
			    	try
			    	{
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter a number of employee:");
				    	value=sc.nextInt();
			    		
			    		elist=new ArrayList<Emp>(value);
				    	
				    	for(int i=0; i<value; i++)
				    	{
				    		System.out.println("Enter employee id:");
				    		e_id=sc.nextInt();
				    		
				    		System.out.println("Enter employee name:");
				    		e_name=sc.next();
				    		
				    		
				    		emp=new Emp();
				    		
				    		emp.setE_id(e_id);
				    		emp.setE_name(e_name);
				    		
				    		elist.add(emp);
				    		em.persist(emp);
				    		
				    		
				    	}
				    	company.setEmplist(elist);
				    	em.persist(company);
				    	
				    	et.commit();
				    	System.out.println("Record Inserted");
				    	
				    	
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
		    		
			    	
			    	
			    }
			    case 2:
			    {
			    	try
			    	{
			    		String hql="from Company";
			    		
			    		Query query=em.createQuery(hql);
			    		
			    		clist = query.getResultList();
			    		
			    		for(int i=0; i < clist.size(); i++)
			    		{
			    			company= clist.get(i);
			    			System.out.println("Company ID:"+company.getC_id()+"   "+"Company Name:"+company.getC_name());
			    			
			    			elist = company.getEmplist();
			    			
			    			for(int j=0; j<elist.size(); i++)
			    			{
			    				emp=elist.get(j);
			    				
			    				System.out.println("Employee ID:"+emp.getE_id()+"   "+"Employee Name:"+emp.getE_name());
			    			}
			    		}
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
			    }
			    case 3:
			    {
			    	try
			    	{
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter employee id:");
			    		e_id=sc.nextInt();
			    		
			    		emp=em.find(Emp.class,e_id);
			    		
			    		if(emp != null)
			    		{
			    			System.out.println("User already exists");
			    		}
			    		else
			    		{
			    			emp=new Emp();
				    		
				    		System.out.println("Enter Employee name:");
				    		e_name=sc.next();
				    		
				    		emp.setE_id(e_id);
				    		emp.setE_name(e_name);
				    		
				    		
				    		company=new Company();
				    		
				    		System.out.println("Enter company id:");
				    		c_id=sc.nextInt();
				    		
				    		company=em.find(Company.class, c_id);
				    		
				    		if(company != null)
				    		{
				    			emp.setCompany(company);
				    			System.out.println("Record inserted");
				    		}
				    		else
				    		{
				    			System.out.println("Enter company name: ");
					    		c_name = sc.next();
					    		
					    		company = new Company();
					    		
					    		company.setC_id(c_id);
					    		company.setC_name(c_name);
					    		em.persist(company);
					    		
				    		}
				    		em.persist(emp);
				    		
				    		et.commit();
				    		System.out.println("Record inserted..");
				    		
			    		}
			    		
			    		
			    		
			    	
			    		
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
			    }
			    
			
			}
		}
		while(choice != 0);
	}
}
