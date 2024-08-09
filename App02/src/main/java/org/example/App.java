package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc= new Scanner(System.in);
    	
        EntityManager entityManager = null;
      	 EntityManagerFactory factory=null;
      	 EntityTransaction entityTransaction=null;
      	 
         int num;
      	 
      	 factory=Persistence.createEntityManagerFactory("persistence");
        
         entityManager=factory.createEntityManager();
      
         
         entityTransaction = entityManager.getTransaction();
        do {
        	
        	
        	 System.out.println("CRUD operation:");
             System.out.println("1.Insert Record.");
             System.out.println("2.Delete Record.");
             System.out.println("3.Update Record.");
             System.out.println("4.View Record.");
             System.out.println("5.exit");
             
             System.out.println("Enter the number:");
             num = sc.nextInt();
             
             
             switch(num) {
             
 	        case 1:
 	        	try {
 	        	
 	             System.out.println("Enter the Id:");
 	        	int id=sc.nextInt();
 	        	
 	        	//System.out.println("Enter the Name:");
 	        	//String name=sc.next();
 	        	
 	        	System.out.println("Enter the Address:");
 	        	String add=sc.next();
 	        	      
 	            
 	            entityTransaction.begin();
 	            
 	            
 	            
 	            Student st = new Student();
 	             st.setId(id);
 	        	//st.setName(name);
 	            st.setAddress(add);
 	            
 	            entityManager.persist(st);
 	            entityManager.getTransaction().commit(); 
 	            entityManager.close();
 	            System.out.print("Record Inserted...");
 	        	}
 	        	catch(Exception e)
 	        	{
 	        		System.out.println(e.getMessage());
 	        		entityTransaction.rollback();
 	        	}
 	            
 	        case 2:
 	           {
 	        	   
 	        	try
 	        	{
 	        		
 	        	System.out.println("Enter the id to delte the record:");
 	        	int sid= sc.nextInt();
 	        
 	        	 entityTransaction.begin();
 	        	 
 	        	 
 	        	 Student stu = entityManager.find(Student.class, sid);
 	        	 
 	        	 entityManager.remove(stu);
 	        	 entityManager.getTransaction().commit();
 	        	 entityManager.close();
 	        	 System.out.println("Record deleted...");
 	        	}
 	        	catch(Exception e)
 	        	{
 	        		System.out.println(e.getMessage());
 	        		entityTransaction.rollback();
 	        	}
 	        	

 	           }
 	           
 		        case 3:
 		        {
 		        	
 		        	System.out.println("Enter the id for udate record:");
 		        	int Id= sc.nextInt();
 		        
 		        	
 		        	System.out.println("Enter the name:");
 		        	String n1 = sc.next();
 		        	
 		        	System.out.println("Enter the address:");
 		        	String a1 = sc.next();
 		        		
 		        	EntityTransaction eTransaction = entityManager.getTransaction();
 		        	eTransaction.begin();
 		        	
 		        	Student std=entityManager.find(Student.class,Id);
 		        	
 		        	std.setName(n1);
 		        	std.setAddress(a1);
 		        	entityManager.getTransaction().commit();
 		        	entityManager.close();
 		        	
 		        	System.out.println("Record updated...");
 		        }
 		        
 		        case 4:
 		        {
 		        	

 		       	
 	        	        String jpql = "FROM Student";
 	        	      Query query = entityManager.createQuery(jpql, Student.class);
 	        	      
 	        	      ArrayList<Student> alist = (ArrayList<Student>) query.getResultList();
 	        	      
 	        	      for(int i=0; i < alist.size(); i++)
 	        	      {
 	        	    	  Student st1 = alist.get(i);
 	        	    	  System.out.println("--------------");
 	        	    	  
 	        	    	  System.out.println("Id:"+st1.getId() + "Name:"+st1.getName()+"Address:"+st1.getAddress());
 	        	    	 
 	        	      }
 	        	      
 	        	   

 		       
 	          
 	        	  }
 			        case 5:
 			        {
 			        	
 			        	System.exit(0);
 			        
 			        	
 			        }
 			     
            
 	          
 	        
         
         }
             
        }
        while(num!=0);
       
        
       
        
    
        
       




	}
        
        
        

}

