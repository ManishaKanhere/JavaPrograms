package com.example.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import com.example.entity.Employee;

public class ReadAllRecords {

	public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("PU");
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	entityManager.getTransaction().begin();
	
	String query="select e from Employee e";
	//select query e.salary,e.empname from Employee e
	
	Query query1=entityManager.createQuery(query,Employee.class); //Query will hold all rows
	
	List<Employee>employee=query1.getResultList();//converting query into list
	
	for(Employee emp:employee) {
		System.out.println(emp);
	}
	entityManager.getTransaction().commit();
	entityManager.close();

	}

}
