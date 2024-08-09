package org.oneTomany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ManyToOne {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int choice,trainid,eid,value;
		String trainname,ename;
		
		Trainer trainer=new Trainer();
		Trainee trainee=new Trainee();
		
		List<Trainee> traineelist=null;
		List<Trainer> trainerlist=null;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		do
		{
			System.out.println("1.Insert Record from trainer side.");
			System.out.println("2.Insert Record from trainee side.");
			System.out.println("3.Print  Record.");
			System.out.println("4.Search From Trainer Side.");
			System.out.println("5.Search From Trainee Side.");
			System.out.println("6.Delete Record Trainer.");
			System.out.println("7:Delete Trainee Records using trainer id.");
			
			System.out.println("Enter Your choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
				   case 1:
				   {
					   trainer=new Trainer();
					   
					   System.out.println("Enter Trainer id:");
					   trainid=sc.nextInt();
					   
					   System.out.println("Enter Trainer name:");
					   trainname=sc.next();
					   
					   trainer.setTrainid(trainid);
					   trainer.setTrainname(trainname);
					   
					   System.out.println("Enter number of trainee");
					   value=sc.nextInt();
					   
					   try
					   {
						   et=em.getTransaction();
						   et.begin();
						   
						  
						   
						   traineelist=new ArrayList<Trainee>(value);
						   
						   for(int i=0; i<value; i++)
						   {
							   System.out.println("Enter Trainee Id:");
							   eid=sc.nextInt();
							   
							   System.out.println("Enter Trainee Name:");
							   ename=sc.next();
							   
							   trainee=new Trainee();
							   
							   trainee.setEid(eid);
							   trainee.setEname(ename);
							   trainee.setTrainer(trainer);
							   
							   traineelist.add(trainee);
							   em.persist(trainee);
							   
						   }
						   trainer.setTraineelist(traineelist);
						   em.persist(trainer);
						   
						   et.commit();
						   System.out.println("Record Inserted..");
					   }
					   catch(Exception e)
					   {
						   System.out.println(e.getMessage());
						   et.begin();
					   }
					   break;
				   }
				   
				   
				   case 2:
				   {
					   et=em.getTransaction();
						  et.begin();
						  
					   
					  System.out.println("Enter Trainee Id:");
					  eid=sc.nextInt();
					  
					  trainee=em.find(Trainee.class, eid);
					  
					  if(trainee != null)
					  {
						  System.out.println("Already Exsits");
					  }
					  else
					  {
						  
						  trainee=new Trainee();
						  
						  System.out.println("Enter Trainee Name:");
						  ename=sc.next();
						  
						  trainee.setEid(eid);
						  trainee.setEname(ename);
						  
						  trainer=new Trainer();
						  
						  System.out.println("Enter Trainer id:");
						  trainid=sc.nextInt();
						  
						  trainer=em.find(Trainer.class, trainid);
						  
						  if(trainer != null)
						  {
							  trainee.setTrainer(trainer);
							  System.out.println("Record Inserted");
						  }
						  else
						  {
							  trainer = new Trainer();
							  
							  System.out.println("Enter Trainer Name:");
							  trainname=sc.next();
							  
							  trainer.setTrainid(trainid);
							  trainer.setTrainname(trainname);
							  trainee.setTrainer(trainer);
							  em.persist(trainer);
						  }
						  em.persist(trainee);
                          et.commit();
					  }
					 break;
				   }
				   case 3:
				   {
					   try
					   {
						   String hql="from Trainer";
						   
						   Query query=em.createQuery(hql);
						   
						   trainerlist=query.getResultList();
						   
						   for(int i=0; i<=trainerlist.size(); i++)
						   {
							   trainer=trainerlist.get(i);
							   System.out.println("Trainer Id:"+trainer.getTrainid()+"    "+"Trainer Name:"+trainer.getTrainname());
							  							  
							   traineelist=trainer.getTraineelist();
							   
							   for(int j=0; j<traineelist.size(); j++)
							   {
								   trainee=traineelist.get(j);
								   System.out.println("Trainee Id:"+trainee.getEid()+"    "+"Trainee Name:"+trainee.getEname()+"    "+"Trainer ID:"+trainee.getTrainer().getTrainid());
							   }
							   
							   
						   }
						   
					   }
					   catch(Exception e)
					   {
						   System.out.println(e.getMessage());
					   }
					   break;
				   }
				   case 4:
				   {
					   try
					   {
						   et=em.getTransaction();
						   et.begin();
						   
						 System.out.println("Enter Trainer Id to search record:");
						 trainid=sc.nextInt();
						 
						 trainer=em.find(Trainer.class,trainid);
						 
						 if(trainer != null)
						 {
							 System.out.println("Record Found...");
							 
							 System.out.println("Trainer Id:"+trainer.getTrainid()+"   "+"Trainer Name:"+trainer.getTrainname());
							 
							 
							 traineelist=trainer.getTraineelist();
							 
							 for(int i=0; i<traineelist.size(); i++) 
							 {
								 trainee=traineelist.get(i);
								 
								 System.out.println("Trainee Id:"+trainee.getEid()+"    "+"Trainee Name:"+trainee.getEname()+"    "+"Trainer Id:"+trainee.getTrainer().getTrainid());
							 }
						 }
						 else
						 {
							 System.out.println("Record Not Found..");
						 }
						 et.commit();
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
						   
						   System.out.println("Enter Trainee Id to search record:");
						   eid=sc.nextInt();
						   
						   trainee=em.find(Trainee.class, eid);
						   
						   if(trainee != null)
						   {
							   System.out.println("Record Found....");
							   
							   System.out.println("Trainee Id:"+trainee.getEid()+"    "+"Trainee Name:"+trainee.getEname()+"     "+"Trainer Id:"+trainee.getTrainer().getTrainid());
							   
							   trainer=trainee.getTrainer();
							   
							   System.out.println("Trainer ID:"+trainer.getTrainid()+"    "+"Trainer Name:"+trainer.getTrainname());
						   }
						   else
						   {
							  System.out.println("Record Not Found....");
						   }
						   et.commit();
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
						   
						   System.out.println("Enter Trainer Id to delete records:");
						   trainid=sc.nextInt();
						   
						   trainer=em.find(Trainer.class, trainid);
						   
						   if(trainer != null)
						   {
							   System.out.println("Recor Found...");
							   
							   em.remove(trainer);
							   et.commit();
							   System.out.println("Trainer Record Deleted..");
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
				   case 7:
				   {
					   try
					   {
						   et=em.getTransaction();
						   et.commit();
						   
						   System.out.println("Enter Trainer id:");
						   trainid=sc.nextInt();
						   
						   trainer=em.find(Trainer.class, trainid);
						   
						   if(trainer != null)
						   {
							   System.out.println("Trainer Found..");
							   
							   traineelist=trainer.getTraineelist();
							   
							   for(int i=0; i<traineelist.size(); i++)
							   {
								   trainee=traineelist.get(i);
								   eid=trainee.getEid();
								   
								   em.remove(eid);
								  
								   
							   }
							   et.commit();
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
