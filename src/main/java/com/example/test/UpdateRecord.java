package com.example.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entity.Employee;

public class UpdateRecord {

	public static void main(String[] args) {
		//to obtain EntityManagerFactory instance
				EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("PU");
				
				// to obtain instance of EntityManager
				
				EntityManager entityManager=entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				Employee employee=entityManager.find(Employee.class ,127);
				employee.setSalary(70000);
				employee.setDeptName("Developer");
				entityManager.getTransaction().commit();
				
				System.out.println("record is updated");
				entityManager.close();

	}

}
