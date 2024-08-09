package org.manyTomany;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class InheritanceExample {

	public static void main(String[] args)
	{
        Scanner sc=new Scanner(System.in);
		
		int choice,id,salary,experience,pension;
		String name;
		ActiveStaff as=null;
		RetiredStaff rs=null;
		EntityManager em=null;
		
		EntityManagerFactory emf = null;
		EntityTransaction et=null;
		
		List<ActiveStaff> alist= null;
		List<RetiredStaff> rlist= null;
		
		emf=Persistence.createEntityManagerFactory("persistence");
		 em=emf.createEntityManager();
		 et=em.getTransaction();

		
		do
		{
			System.out.println("1.Insert Record to active staff:");
			System.out.println("2.Insert Record to retired staff:");
			System.out.println("3.Print Record for Active staff");
			System.out.println("4.Print Record For Retired staff:");
			System.out.println("5.Delete Active staff record using staff id.");
			System.out.println("6.Delete Retired staff record using staff id.");
			System.out.println("7.Search record from Active staff.");
			System.out.println("8.Search Record from Retired Staff.");
			
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
			     case 1: 
			     {
			    	 as=new ActiveStaff();
			    	 
			    	 System.out.println("Enter Staff id:");
			    	 id=sc.nextInt();
			    	 
			    	 System.out.println("Enter Staff name:");
			    	 name=sc.next();
			    	 
			    	 System.out.println("Enter Staff Salary:");
			    	 salary=sc.nextInt();
			    	 
			    	 System.out.println("Enter Staff experience:");
			    	 experience=sc.nextInt();
			    	 
			    	 as.setId(id);
			    	 as.setName(name);
			    	 as.setS_salary(salary);
			    	 as.setS_experience(experience);
			    	 
			    	 try
			    	 {
			    		 et=em.getTransaction();
			    		 et.begin();
			    		 
			    		 em.persist(as);
			    		 et.commit();
			    		 System.out.println("Record inserted");
			    	 }
			    	 catch(Exception e)
			    	 {
			    		 System.out.println(e.getMessage());
			    		
			    	
			    	 }
			    	 break;
			    	 
			    
			     }
			     case 2: 
			     {
			    	 rs=new RetiredStaff();
			    	 
			    	 System.out.println("Enter Staff id:");
			    	 id=sc.nextInt();
			    	 
			    	 System.out.println("Enter Staff name:");
			    	 name=sc.next();
			    	 
			    	 System.out.println("Enter Staff pension:");
			    	 pension=sc.nextInt();
			    	 
			    	 
			    	 rs.setId(id);
			    	 rs.setName(name);
			    	 rs.setS_pension(pension);
			    	
			    	 
			    	 try
			    	 {
			    		 et=em.getTransaction();
			    		 et.begin();
			    		 
			    		 em.persist(rs);
			    		 et.commit();
			    		 System.out.println("Record inserted");
			    	 }
			    	 catch(Exception e)
			    	 {
			    		 System.out.println(e.getMessage());
			    		et.rollback();
			    	
			    	 }
			    	 
			    	 break;
			    	 
			     }
			     case 3:
			     {
			    	 try
			    	 {
			    		 String hql="from ActiveStaff";
			    		 
			    		 Query query=em.createQuery(hql);
			    		 
			    		 alist=query.getResultList();
			    		 
			    		 for(int i=0; i < alist.size(); i++)
			    		 {
			    			 as=alist.get(i);
			    			 
			    			 System.out.println("Active staff id:"+as.getId()+"   "+"Active Staff Name:"+as.getName()+"    "+"Active Staff Experience:"+as.getS_experience()+"    "+"Active Staff salary:"+as.getS_salary());
			    		 }
			    		
			    		 
			    	 }
			    	 catch(Exception e)
			    	 {
			    		 System.out.println(e.getMessage());
			    		et.rollback();
			    	
			    	 }
			    	 break;
			    	 
			     }
			     case 4:
			     {
			    	 try
			    	 {
			    		 String hql="from RetiredStaff";
			    		 
			    		 Query query=em.createQuery(hql);
			    		 
			    		 rlist=query.getResultList();
			    		 
			    		 for(int i=0; i < rlist.size(); i++)
			    		 {
			    			 rs=rlist.get(i);
			    			 
			    			 System.out.println("Retired staff id:"+rs.getId()+"   "+"Retired Staff Name:"+rs.getName()+"    "+"Retired Staff Pension:"+rs.getS_pension());
			    		 }
			    		
			    		 
			    	 }
			    	 catch(Exception e)
			    	 {
			    		 System.out.println(e.getMessage());
			    		et.rollback();
			    	
			    	 }
			    	 break;
			    	 
			     }
			     case 5:
			     {
			    	 try
			    	 {
			    		et=em.getTransaction();
			    		et.begin();
			    		
			    		System.out.println("Enter Active Staff id:");
			    		id=sc.nextInt();
			    		
			    		as=em.find(ActiveStaff.class, id);
			    		
			    		if(as != null)
			    		{
			    			System.out.println("Record Found..");
			    			
			    			em.remove(as);
			    			et.commit();
			    		}
			    		else
			    		{
			    			System.out.println("Record Not Found!!!!");
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
				    		
				    		System.out.println("Enter Retired Staff id:");
				    		id=sc.nextInt();
				    		
				    		rs=em.find(RetiredStaff.class, id);
				    		
				    		if(rs != null)
				    		{
				    			System.out.println("Record Found..");
				    			
				    			em.remove(rs);
				    			et.commit();
				    		}
				    		else
				    		{
				    			System.out.println("Record Not Found!!!!");
				    		}
			    	 }
			    	 catch(Exception e)
			    	 {
			    		 System.out.println(e.getMessage());
			    		et.rollback();
			    	
			    	 }
			    	 break;
			    	 
			     }
			     case 7:
			     {
			    	 try
			    	 {
			    		 et=em.getTransaction();
				    		et.begin();
				    		
				    		System.out.println("Enter Active Staff id:");
				    		id=sc.nextInt();
				    		
				    		as=em.find(ActiveStaff.class, id);
				    		
				    		if(as != null)
				    		{
				    			System.out.println("Record Found..");
				    			
				    			System.out.println("Active staff id:"+as.getId()+"   "+"Active Staff Name:"+as.getName()+"    "+"Active Staff Experience:"+as.getS_experience()+"    "+"Active Staff salary:"+as.getS_salary());
				    			et.commit();
				    		}
				    		else
				    		{
				    			System.out.println("Record Not Found!!!!");
				    		}
			    	 }
			    	 catch(Exception e)
			    	 {
			    		 System.out.println(e.getMessage());
			    		et.rollback();
			    	
			    	 }
			    	 break;
			     }
			     case 8:
			     {
			    	 try
			    	 {
			    		 et=em.getTransaction();
				    		et.begin();
				    		
				    		System.out.println("Enter Retired Staff id:");
				    		id=sc.nextInt();
				    		
				    		rs=em.find(RetiredStaff.class, id);
				    		
				    		if(rs != null)
				    		{
				    			System.out.println("Record Found..");
				    			
				    			System.out.println("Retired staff id:"+rs.getId()+"   "+"Retired Staff Name:"+rs.getName()+"    "+"Retired Staff Pension:"+rs.getS_pension());
				    			et.commit();
				    		}
				    		else
				    		{
				    			System.out.println("Record Not Found!!!!");
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
