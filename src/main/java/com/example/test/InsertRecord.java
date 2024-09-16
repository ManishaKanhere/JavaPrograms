package com.example.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entity.Employee;

public class InsertRecord {

	public static void main(String[] args) {
		LocalDate customJoiningDate=LocalDate.of(2023, 07, 15);
		Employee emp=new Employee(131,"Meera",9000," Accountant",customJoiningDate);
		
		//to obtain EntityManagerFactory instance
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("PU");
		
		// to obtain instance of EntityManager
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println(emp);
		
	}

}
