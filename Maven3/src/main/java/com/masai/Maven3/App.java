package com.masai.Maven3;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App 
{
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("Raushan4");
	}
	
	
    public static void main( String[] args )
    {
       Scanner sc=new Scanner(System.in);
       int c;
       do {
    	   System.out.println("1. Add Author");
    	   System.out.println("2.  display Author");
    	   System.out.println("3. Update Author");
    	   System.out.println("4. Delete Author");
    	   System.out.println("0. Exit");

    	   
    	   c=sc.nextInt();
    	   switch(c) {
    	   case 1:
    		   Add(sc);
    		   break;
    	   case 2:
    		   display(sc);
    		   break;
    	   case 3:
    		   Update(sc);
    		   break;
    	   case 4:
    		   Delete(sc);
    		   break;
    	   case 0:
    		  System.out.println("Thanks");
    		   break;
    		   
    		   
    	   }
       }
       while(c!=0);
       sc.close();
    }


	private static void Add(Scanner sc) {
		System.out.println("Enter id");
		int id =sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter rating");
		double rating =sc.nextDouble();
		
		Author4 a=new Author4(id,name,rating);
		
		AddAuthor(a);
		
	}


	private static void AddAuthor(Author4 a) {
	  EntityManager em=emf.createEntityManager();
	  
	  EntityTransaction et =em.getTransaction();
	  
	  et.begin();
	  em.persist(a);
	  et.commit();
	  em.close();
		
	}


	private static void display(Scanner sc) {
		System.out.println("Enter id");
		int id =sc.nextInt();
		
		Disp(id);
		
		
		
	}


	private static void Disp(int id) {
		EntityManager em=emf.createEntityManager();
		
		Author4 t=em.find(Author4.class, id);
		
		if(t==null) {
			System.out.println("No record found");
			
		}
		else {
		System.out.println("id :" +t.getId() + "name :"+t.getName()+ "rating"+t.getRating());
		}
		
	}


	private static void Update(Scanner sc) {
		System.out.println("Enter id");
		int id =sc.nextInt();
		System.out.println("Enter rating");
		double rating =sc.nextDouble();
		
		UpdateAuthor(id,rating);
		
		
	}


	private static void UpdateAuthor(int id, double rating) {
EntityManager em=emf.createEntityManager();
		
		Author4 t=em.find(Author4.class, id);
		
		if(t==null) {
			System.out.println("No record found");
			
		}
		
		else {
			EntityTransaction et=em.getTransaction();
			et.begin();
			t.setRating(rating);
			et.commit();
			System.out.println("Success");
		}
		em.close();
		
	}


	private static void Delete(Scanner sc) {
		System.out.println("Enter id");
		int id =sc.nextInt();
		
		DeleteAuthor(id);
		
	}


	private static void DeleteAuthor(int id) {
EntityManager em=emf.createEntityManager();
		
		Author4 t=em.find(Author4.class, id);
		
		if(t==null) {
			System.out.println("No record found");
			
		}
		
		else {
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.remove(t);
			et.commit();
			System.out.println("Success");
		}
		em.close();
		
	}
}
