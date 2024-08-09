package org.oneToone;

import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OneToOne {

	public static void main(String args[]) 
	{
		Scanner sc=new Scanner(System.in);
		
		int lid,sid,value,choice;
		String lname,sname;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Student27 st= new Student27();
		Laptop lap= new Laptop();
		ArrayList<Student27> stlist=null;
		ArrayList<Laptop> laplist=null;
		
		do
		{
			System.out.println("1.Insert Record from student side:");
			System.out.println("2.Print Student Record");
			System.out.println("3.Print Laptop Record");
			System.out.println("4.Search Record");
			System.out.println("5.Delete Particular Record");
			System.out.println("6.Change Laptop Name Using Particular Laptop Id:");
			System.out.println("7.Exit");
			System.out.println("Enter a number:");
			choice=sc.nextInt();
			
			switch(choice)
			{
				  case 1:
				  {
					 et=em.getTransaction();
					 et.begin();
					 
					  st=new Student27();
					  
					  System.out.println("Enter a student id:");
					  sid=sc.nextInt();
					  
					  System.out.println("Enter a student name:");
					  sname=sc.next();
					  
					  st.setSid(sid);
					  st.setSname(sname);
					 
					  lap=new Laptop();
					  
					  System.out.println("Enter a laptop id:");
					  lid=sc.nextInt();
					  
					  System.out.println("Enter a laptop name:");
					  lname=sc.next();
					  
					  lap.setLaptop_id(lid);
					  lap.setLaptop_name(lname);
					  
					  st.setLaptop(lap);
					  
					  em.persist(st);
					  em.persist(lap);
					  
					  et.commit();
					  
					  System.out.println("Record inserted..");
					  break;
				  }
				  case 2:
				  {
					  try
					  {
						  String jpql="from Student27";
						  
						  Query query=em.createQuery(jpql,Student27.class);
						  
						  stlist= (ArrayList<Student27>) query.getResultList();
						  
						  for(int i=0;i<stlist.size(); i++)
						  {
							  st=stlist.get(i);
							  System.out.println("Student Id:"+st.getSid()+"     "+"Student Name:"+st.getSname()+"    "+"Laptop id:"+ st.getLaptop().getLaptop_id());
							  
						  }
						  break;
						 
						  
						  
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
						  String jpql="from Laptop";
						  
						  Query query=em.createQuery(jpql,Laptop.class);
						  
						  laplist=(ArrayList<Laptop>) query.getResultList();
						  
						  for(int i=0; i<laplist.size(); i++)
						  {
							  lap=laplist.get(i);
							  
							  System.out.println("Laptop Id:"+lap.getLaptop_id()+"   "+"Laptop Name:"+lap.getLaptop_name());
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
						  
						  System.out.println("Enter Student id:");
						  sid=sc.nextInt();
						  
						  st=em.find(Student27.class, sid);
						  
						  if(st != null)
						  {
							  System.out.println("Record Found..");
							  
							  System.out.println("Student id:"+st.getSid()+"   "+"Student Name:"+st.getSname()+"    "+"Laptop Id:"+st.getLaptop().getLaptop_id());
						  }
						  else
						  {
							  System.out.println("Record not found!!!");
						  }
						  
						  et.commit();
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
						  
						  System.out.println("Enter Student id:");
						  sid=sc.nextInt();
						  
						  st=em.find(Student27.class,sid);
						  
						  if(st != null)
						  {
							 em.remove(st);
							 et.commit();
							 System.out.println("Record Deleted Succucessfully...");
						  }
						  else
						  {
							  System.out.println("Does not exists..");
						  }
					  }
					  catch(Exception e)
					  {
						  System.out.println(e.getMessage());
						  et.rollback();
					  }
				  }
				  case 6:
				  {
					  try
					  {
						  et=em.getTransaction();
						  et.begin();
						  
						  System.out.println("Enter Laptop Id:");
						  lid=sc.nextInt();
						  
						  String hql="update Laptop set laptop_name =: lname where laptop_id =: lid";
						  
						  System.out.println("Enter Laptop name:");
						  lname=sc.next();
						  
						  Query query=em.createQuery(hql);
						  query.setParameter("lid", lid);
						  query.setParameter("lname", lname);
						  
						  query.executeUpdate();
						  
						  et.commit();
						  em.close();
						  System.out.println("Record Updated Successfully...");
					  }
					  catch(Exception e)
					  {
						  System.out.println(e.getMessage());
						  et.rollback();
					  }
				  }
				  
				  
			}
			
		}
		while(choice!=0);
		
	}
}
