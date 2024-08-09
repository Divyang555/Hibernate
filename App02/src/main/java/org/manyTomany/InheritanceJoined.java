package org.manyTomany;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class InheritanceJoined {

	public static void main(String args[])
	{
		 Scanner sc=new Scanner(System.in);
			
			int choice,id,fee,salary;
			String name;
			
			Pupil pupil=null;
			Tutor tutor=null;
			EntityManager em=null;
			
			List<Pupil> plist=null;
			List<Tutor> tlist=null;
			
			EntityManagerFactory emf = null;
			EntityTransaction et=null;
			
			
			emf=Persistence.createEntityManagerFactory("persistence");
			 em=emf.createEntityManager();
			 et=em.getTransaction();

			 do
			 {
				 System.out.println("1.Insert Record from pupil.");
				 System.out.println("2.Insert Record from Tutor.");
				 System.out.println("3.Print Record from pupil.");
				 System.out.println("4.Print Record from tutor");
				 System.out.println("5.Delete pupil record using pupil id.");
			     System.out.println("6.Delete tutor record using tutor id.");
				 System.out.println("7.Search record from pupil.");
				 System.out.println("8.Search Record from tutor.");
				 
				 System.out.println("Enter your choice:");
				 choice=sc.nextInt();
				 
				 switch(choice)
				 {
				     case 1:
				     {
				    	 try
				    	 {
				    		 et=em.getTransaction();
				    		 et.begin();
				    		 
				    		 pupil=new Pupil();
				    		 
				    		 System.out.println("Enter pupil Id:");
				    		 id=sc.nextInt();
				    		 
				    		 System.out.println("Enter a pupil Name:");
				    		 name=sc.next();
				    		 
				    		 System.out.println("Enter a pupil fees:");
				    		 fee=sc.nextInt();
				    		 
				    		
				    		 pupil.setId(id);
				    		 pupil.setName(name);
				    		 pupil.setFee(fee);
				    		 
				    		 em.persist(pupil);
				    		 et.commit();
				    		 
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
				    	 try
				    	 {
				    		 et=em.getTransaction();
				    		 et.begin();
				    		 
				    		 tutor=new Tutor();
				    		 
				    		 System.out.println("Enter tutor Id:");
				    		 id=sc.nextInt();
				    		 
				    		 System.out.println("Enter a tutor Name:");
				    		 name=sc.next();
				    		 
				    		 System.out.println("Enter a tutor salary:");
				    		 salary=sc.nextInt();
				    		 
				    		
				    		 tutor.setId(id);
				    		 tutor.setName(name);
				    		 tutor.setSalary(salary);
				    		 
				    		 em.persist(tutor);
				    		 et.commit();
				    		 
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
				    		 String hql="from Pupil";
				    		 
				    		 Query query=em.createQuery(hql);
				    		 
				    		 plist=query.getResultList();
				    		 
				    		 for(int i=0; i<plist.size(); i++)
				    		 {
				    			  pupil=plist.get(i);
				    			  
				    			  System.out.println("Pupil Id:"+pupil.getId()+"    "+"Pupil Name:"+pupil.getName()+"    "+"Pupil Fees:"+pupil.getFee());
				    			  
				    			  
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
				    		 String hql="from Tutor";
				    		 
				    		 Query query=em.createQuery(hql);
				    		 
				    		 tlist=query.getResultList();
				    		 
				    		 for(int i=0; i<tlist.size(); i++)
				    		 {
				    			  tutor=tlist.get(i);
				    			  
				    			  System.out.println("Tutor Id:"+tutor.getId()+"    "+"Tutor Name:"+tutor.getName()+"    "+"Tutor Salary:"+tutor.getSalary());
				    			  
				    			  
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
				    		 
				    		 System.out.println("Enter Pupil id to delete record:");
				    		 id=sc.nextInt();
				    		 
				    		 pupil=em.find(Pupil.class, id);
				    		 
				    		 if(pupil != null)
				    		 {
				    			 System.out.println("Record Found..");
				    			 
				    			 em.remove(pupil);
				    			 et.commit();
				    			 System.out.println("Record Deleted..");
				    		 }
				    		 else
				    		 {
				    			 System.out.println("Record Not Found!!");
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
				    		 
				    		 System.out.println("Enter Tutor id to delete record:");
				    		 id=sc.nextInt();
				    		 
				    		 tutor=em.find(Tutor.class, id);
				    		 
				    		 if(tutor != null)
				    		 {
				    			 System.out.println("Record Found..");
				    			 
				    			 em.remove(tutor);
				    			 et.commit();
				    			 System.out.println("Record Deleted..");
				    		 }
				    		 else
				    		 {
				    			 System.out.println("Record Not Found!!");
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
				    		 
				    		 System.out.println("Enter Pupil id:");
				    		 id=sc.nextInt();
				    		 
				    		 pupil=em.find(Pupil.class, id);
				    		 
				    		 if(pupil != null)
				    		 {
				    			 System.out.println("Record Found..");
				    			 
				    			  System.out.println("Pupil Id:"+pupil.getId()+"    "+"Pupil Name:"+pupil.getName()+"    "+"Pupil Fees:"+pupil.getFee());
				    			 
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
				    		 
				    		 System.out.println("Enter Tutor id:");
				    		 id=sc.nextInt();
				    		 
				    		 tutor=em.find(Tutor.class, id);
				    		 
				    		 if(tutor != null)
				    		 {
				    			 System.out.println("Record Found..");
				    			 
				    			 System.out.println("Tutor Id:"+tutor.getId()+"    "+"Tutor Name:"+tutor.getName()+"    "+"Tutor Salary:"+tutor.getSalary());				    			 
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
