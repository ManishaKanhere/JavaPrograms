package com.example.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entity.Employee;

public class ReadById {

	public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("PU");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	entityManager.getTransaction().begin();
	
	Employee emp=entityManager.find(Employee.class, 127);
	System.out.println(emp);
	entityManager.getTransaction().commit();
	entityManager.close();
	
	}

}
