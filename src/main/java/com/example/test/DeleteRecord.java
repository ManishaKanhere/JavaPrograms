
package com.example.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entity.Employee;

public class DeleteRecord {
	public static void main(String[]ar) {
		//to obtain EntityManagerFactory instance
				EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("PU");
				
				// to obtain instance of EntityManager
				
				EntityManager entityManager=entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				
				Employee emp=entityManager.find(Employee.class,128);
				entityManager.remove(emp);
				System.out.println("deleted successefully");
				entityManager.getTransaction().commit();
				entityManager.close();
	}

}
