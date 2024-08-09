package org.oneToone;

import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OneToOneExample 
{
	   
	public static void main( String[] args )
    {
    	Scanner sc= new Scanner(System.in);
    	
    	String name,bname;
    	int id,num,bid,Bid;
    	
    	
        EntityManager entityManager = null;
      	 EntityManagerFactory factory=null;
      	 EntityTransaction entityTransaction=null;
      	 Student1 student = new Student1();
      	 Library library=null;
      	 
       
      	 
      	 factory=Persistence.createEntityManagerFactory("persistence");
        
         entityManager=factory.createEntityManager();
      
         
         entityTransaction = entityManager.getTransaction();
        
        {
        	
        	
        	 System.out.println("CRUD operation:");
             System.out.println("1.Insert Record.");
             System.out.println("2.Delete Student Record.");
             System.out.println("3.Delete Library Record.");
             System.out.println("4.View Student Record.");
             System.out.println("5.View Library Record.");
             System.out.println("6.exit");
             
             System.out.println("Enter the number:");
             num = sc.nextInt();
             
             
             switch(num) 
             {
             
		 	        case 1:
		 	        {
		 	        	
		 	           student = new Student1();
		 	           
		 	           System.out.println("Enter student id:");
		 	           id=sc.nextInt();
		 	           
		 	           System.out.println("Enter Student name:");
		 	           name=sc.next();
		 	           
		 	           student.setId(id);
		 	           student.setName(name);
		 	           
		 	           library=new Library();
		 	           
		 	          System.out.println("Enter Book id:");
			           bid=sc.nextInt();
			           
			           System.out.println("Enter Book name:");
			           bname=sc.next();
			           
			           library.setB_id(bid);
			           library.setB_name(bname);
			           library.setStudent1(student);
			           
			           try
			           {
			        	    entityTransaction=entityManager.getTransaction();
			        	    entityTransaction.begin();
			        	    
			        	    //entityManager.persist(student);
			        	    entityManager.persist(library);
			        	    
			        	    entityTransaction.commit();
			        	    System.out.println("Record inserted");
			        	   
			           }
			           catch(Exception e)
			           {
			        	   System.out.println(e.getMessage());
			        	   entityTransaction.rollback();
			           }
		 	           
		 	           
		 	        	break;
		 	        }
		 	        
		 	        case 2:
			        {
			        	System.out.println("Enter the Book Id:");
			        	id=sc.nextInt();
			        	
			        	entityTransaction.begin();
			        	
			        	Student1 std = entityManager.find(Student1.class, id);//find method only run accroding to primary key 
			        	
			        	entityManager.remove(std);
			        	entityManager.getTransaction().commit();
			        	entityManager.close();
			        		
			            break;
			        }
			        
		 	        case 3:
			        {
			        	System.out.println("Enter the Book Id:");
			        	Bid=sc.nextInt();
			        	
			        	entityTransaction.begin();
			        	
			        	Library lib = entityManager.find(Library.class, Bid);
			        	
			        	entityManager.remove(lib);
			        	entityManager.getTransaction().commit();
			        	entityManager.close();
			        	System.out.println("Book Record deleted");
			        	break;
			        }
			        
		 	        case 4:
			        {
			        	 String jpql = "FROM Student1";
	 	        	      Query query = entityManager.createQuery(jpql, Student1.class);
	 	        	      
	 	        	      ArrayList<Student1> stlist = (ArrayList<Student1>) query.getResultList();
	 	        	      
	 	        	      for(int i=0; i < stlist.size(); i++)
	 	        	      {
	 	        	    	  student= stlist.get(i);
	 	        	    	  System.out.println("--------------");
	 	        	    	  
	 	        	    	  System.out.println("Id:"+student.getId() + "Name:"+student.getName());
	 	        	      }
	 	        	    	  
			        	break;
			        }
		 	       case 5:
			        {
			        	 String jpql = "FROM Library";
	 	        	      Query query = entityManager.createQuery(jpql, Library.class);
	 	        	      
	 	        	      ArrayList<Library> Liblist = (ArrayList<Library>) query.getResultList();
	 	        	      
	 	        	      for(int i=0; i < Liblist.size(); i++)
	 	        	      {
	 	        	    	  library = Liblist.get(i);
	 	        	    	  System.out.println("--------------");
	 	        	    	  
	 	        	    	  System.out.println("BookId:"+library.getB_id() + "BookName:"+library.getB_name()+"Studentid:"+student.getId());
	 	        	      }
	 	        	    	  
			        	break;
			        }
			        
		 	      case 6:
			        {
			            System.out.println("Enter student id to be deleted:");
			            id=sc.nextInt();
			            
			            String hql="delete from Library where student1.id =:sid";
			           
			            try {
			            	
			            	entityTransaction=entityManager.getTransaction();
			            	entityTransaction.begin();
			            	
			            	Query query = entityManager.createQuery(hql);
			            	query.setParameter("sid", id);
				        	
			            	query.executeUpdate();
			            	
				        	//entityManager.remove(lib);
				        	entityTransaction.commit();
				        	entityManager.close();
				        	System.out.println("Book Record deleted");
				        	break;
				        	
			            }
			            catch(Exception e)
				        {
				        	   System.out.println(e.getMessage());
				        	   entityTransaction.rollback();
				        }
			        }
			        
		 	     case 7:
			        {
			            System.out.println("Enter student id:");
			            id=sc.nextInt();
			            
			            String hql="update Library set student1=:val where student1.id =:sid";
			           
			            try {
			            	
			            	entityTransaction=entityManager.getTransaction();
			            	entityTransaction.begin();
			            	
			            	Query query = entityManager.createQuery(hql);
			            	query.setParameter("sid", id);
			            	query.setParameter("val", null);
				        	
			            	query.executeUpdate();
			            	
				        	//entityManager.remove(lib);
				        	entityTransaction.commit();
				        	entityManager.close();
				        	System.out.println("Book Record deleted");
				        	break;
				        	
			            }
			            catch(Exception e)
				        {
				        	   System.out.println(e.getMessage());
				        	   entityTransaction.rollback();
				        }
			        }
		 	    case 8:
		        {
		            System.out.println("Enter student id:");
		            id=sc.nextInt();
		            
		            System.out.println("Enter id of book;");
		            bid=sc.nextInt();
		            
		                     
		            
		           
		            try {
		            	
		            	entityTransaction=entityManager.getTransaction();
		            	entityTransaction.begin();
		            	
		            	 String hql="update Library set student1.id=:val where b_id =: bid";
		            	 
		            	Query query = entityManager.createQuery(hql);
		            	query.setParameter("val", id);
		            	query.setParameter("bid", bid);
			        	
		            	query.executeUpdate();
		            	
			        	//entityManager.remove(lib);
			        	entityTransaction.commit();
			        	
			        	System.out.println("Book Record updated");
			        	break;
			        	
		            }
		            catch(Exception e)
			        {
			        	   System.out.println(e.getMessage());
			        	   entityTransaction.rollback();
			        }
		        }
		        
			 	   case 9:
			        {
			          
			           	System.out.println("Enter the Book Id:");
			        	Bid=sc.nextInt();
			        	
			        	System.out.println("Enter the student Id:");
			        	id=sc.nextInt();
			           
			            try {
			            	
			         
				        	
				        	entityTransaction.begin();
				        	
				        	Library lib = entityManager.find(Library.class, Bid);
				        
				 
				        	Student1 st= entityManager.find(Student1.class, id);
				        	
				        	if(st==null)
				        	{
				        		System.out.println("Student id does not exits");
				        	}
				        
				        	if(lib == null)
				        	{
				        		System.out.println("Book Does not exits");
				        	}
				        	else {
				        		lib.setStudent1(st);
				        	}
				  
				            
				            
				        	entityManager.getTransaction().commit();
				            
				           System.out.println("Book issued");
				        	
				        	break;
			            }
			            catch(Exception e)
				        {
				        	   System.out.println(e.getMessage());
				        	   entityTransaction.rollback();
				        }
			        }
			        
		 	        case 10:
			        {
			        	
			        	System.exit(0);	
			        }
		            
             }
        }
        while(num!=0);
        
    }
	
}
        
        
	        	
 	        	
 	             
 	       
 		        	

 		       	
 		       
 	          
 	        	 
 			        
            
 	          
 	        
         
      
       


