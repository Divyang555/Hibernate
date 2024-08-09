package org.manyTomany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class ManayToManyEx {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		int choice,tid,pid,value;
		String tname,pname;
		Team team=null;
		Player player=null;
		EntityManager em=null;
		
		EntityManagerFactory emf = null;
		EntityTransaction et=null;
		List<Player> plist=null;
		List<Team> tlist=null;
		
		do
		{
			System.out.println("1.Insert Record:");
			System.out.println("2.View Record:");
			System.out.println("3.Insert Record From Emp Side:");
			
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
			    case 1:
			    {
		    	    player=new Player();
		    	    
		    	    System.out.println("Enter Player id:");
		    	    pid=sc.nextInt();
		    	    
		    	    System.out.println("Enter Player Name:");
		    	    pname=sc.next();
		    	    
		    	    player.setId(pid);
		    	    player.setName(pname);
		    	    
		    	    System.out.println("Enter number of team:");
		    	    value=sc.nextInt();
		    	    
			    	try
			    	{
			    		et = em.getTransaction();
			    		et.begin();
			    		
			    		tlist=new ArrayList<Team>(value);
			    		
			    		for(int i=0; i<tlist.size(); i++)
			    		{
			    			System.out.println("Enter Team id:");
			    			tid=sc.nextInt();
			    			
			    			System.out.println("Enter Team name:");
			    			tname=sc.next();
			    			
			    			team = new Team();
			    			
			    			team.setId(tid);
			    			team.setName(tname);
			    			
			    			tlist.add(team);
			    			
			    			em.persist(team);
			    			
			    			
			    		}
			    		player.setTlist(tlist);
			    		em.persist(player);
			    		
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
			    	
			    		team=new Team();
			    	    
			    	    System.out.println("Enter Team id:");
			    	    tid=sc.nextInt();
			    	    
			    	    System.out.println("Enter Team Name:");
			    	    tname=sc.next();
			    	    
			    	    team.setId(tid);
			    	    team.setName(tname);
			    	    
			    	    System.out.println("Enter number of players:");
			    	    value=sc.nextInt();
			    	    
				    	try
				    	{
				    		et = em.getTransaction();
				    		et.begin();
				    		
				    		plist=new ArrayList<Player>(value);
				    		
				    		for(int i=0; i<plist.size(); i++)
				    		{
				    			System.out.println("Enter Player id:");
				    			pid=sc.nextInt();
				    			
				    			System.out.println("Enter Player name:");
				    			pname=sc.next();
				    		
				    			player = new Player();
				    			
				    			player.setId(pid);
				    			player.setName(pname);
				    			
				    			plist.add(player);
				    			
				    			em.persist(player);
				    			
				    			
				    		}
				    		team.setPlist(plist);
				    		em.persist(team);
				    		
				    		et.commit();
				    		System.out.println("Record Inserted");
				
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

