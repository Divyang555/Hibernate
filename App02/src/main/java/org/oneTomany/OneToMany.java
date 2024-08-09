package org.oneTomany;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OneToMany {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int choice,tid,aid,value;
		String tname,city;
		
		
		
		Teacher tech=new Teacher();
		Address add=new Address();
		
		List<Teacher> tlist=null;
		List<Address> alist=null;
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		do
		{
			System.out.println("1.Insert Record From Teacher Side.");
			System.out.println("2.View Record.");
			System.out.println("3.Search Records with Teacher Id:");
			System.out.println("4.Delete Records with Teacher Id:");
			System.out.println("5.Delete Address Record with Teacher id:");
			
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
			    case 1:
			    {
			    	tech=new Teacher();
		    		
		    		System.out.println("Enter Teacher Id:");
		    		tid=sc.nextInt();
		    		
		    		System.out.println("Enter Teacher Name:");
		    		tname=sc.next();
		    		
		    		tech.setT_id(tid);
		    		tech.setT_name(tname);
			    	
			    	try
			    	{
			    		
			    	
			    		
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter a Number of address:");
			    		value=sc.nextInt();
			    		
			    		
			    		alist=new ArrayList<Address>(value);
			    		
			    		for(int i=0; i<value;i++)
			    		{
				    		System.out.println("Enter Address Id:");
				    		aid=sc.nextInt();
				    		
				    		System.out.println("Enter City:");
				    		city=sc.next();
				    		
				    		add=new Address();
				    		
				    		add.setAdd_id(aid);
				    		add.setCity(city);
				    		
				    		alist.add(add);
				    		em.persist(add);
				    		
				    		
			    		}
			    		tech.setAddlist(alist);
			    		em.persist(tech);
			    		et.commit();
			    		System.out.println("Record Inserted..");
			           
			    		
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
			    	break;
			    }
			    case 2:
			    {
			    	String hql="from Teacher";
			    	
			    	Query query=em.createQuery(hql);
			    	
			    	tlist =query.getResultList();
			    	
			    	for(int i=0; i<tlist.size(); i++)
			    	{
			    	     tech= tlist.get(i);
			    	     System.out.println("Teacher Id:"+tech.getT_id()+"   "+"Teacher Name:"+tech.getT_name());
			    	     
			    	     alist=tech.getAddlist();
			    	     for(int j=0; j<alist.size(); j++)
			    	     {
			    	    	 add=alist.get(j);
			    	    	 System.out.println("Address Id:"+add.getAdd_id()+"   "+"Address Name:"+add.getCity());
			    	     }
			    	     
			    	}
			    	break;
			    	
			    	
			    }
			    case 3:
			    {
			    	System.out.println("Enter Teacher Id to search:");
			    	tid=sc.nextInt();
			    	try
			    	{
			    		tech=em.find(Teacher.class, tid);
			    		
			    		if(tech != null)
			    		{
			    			System.out.println("Record Found:");
			    			
			    			System.out.println("Teacher id:"+tech.getT_id()+"   "+"Teacher name:"+tech.getT_name());
			    			
			    			alist=tech.getAddlist();
				    			
							for(int i=0; i<alist.size(); i++)
							{
								add=alist.get(i);
								System.out.println("Address Id:"+add.getAdd_id()+"    "+"City:"+add.getCity());
										
							}
							break;
			    			 
			    		}
			    		else
			    		{
			    			System.out.println("Teacher not found:");
			    		}
			    		
			    		
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
			    }
			    case 4:
			    {
			    	try
			    	{
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter Teacher Id for delete Record:");
			    		tid=sc.nextInt();
			    		
			    		tech=em.find(Teacher.class, tid);
			    		
			    		if(tech != null)
			    		{
			    			em.remove(tech);
			    			et.commit();
			    			System.out.println("Record Deleted..");
			    		}
			    		else
			    		{
			    			System.out.println("Record Not Found:");
			    		}
			    			
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}

			    	
			    	
			    }
			    case 5:
			    {
			    	try
			    	{
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter Teacher id:");
			    		tid=sc.nextInt();
			    		
			    		tech=em.find(Teacher.class,tid);
			    		
			    		if(tech != null)
			    		{
			    			System.out.println("Record Found...");
			    			
			    			alist=tech.getAddlist();
			    			
			    			for(int i=0; i<alist.size(); i++)
			    			{
			    				add=alist.get(i);
			    				int  addid=add.getAdd_id();
			    					
			    				
			    				add=em.find(Address.class, addid);
			    				em.remove(add);
			    		        
			    			}
			    		    et.commit();
			    		    System.out.println("Record Deleted SuccessFully...");
			    		}
			    		else
			    		{
			    			System.out.println("Record Not Found!!!");
			    		}
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
			    	break;
			    }
			    case 6:
			    {
			    	try
			    	{
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter Address id:");
			    		aid=sc.nextInt();
			    		
			    		add=em.find(Address.class,aid);
			    		
			    		if(add != null)
			    		{
			    			System.out.println("Record Found..");
			    			
			    			em.remove(add);
			    			et.commit();
			    			System.out.println("Record Deleted..");
			    		}
			    		else
			    		{
			    			System.out.println("Record Not Found!!!!...");
			    		}
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println(e.getMessage());
			    		et.rollback();
			    	}
			    	break;
			    }
			}
		}
		while(choice != 0);
		
	}

}
