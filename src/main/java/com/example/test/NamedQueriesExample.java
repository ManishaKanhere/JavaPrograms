package com.example.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entity.Employee;

public class NamedQueriesExample {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createNamedQuery("findBySalary");  //2 step   calling namedQuery

		query.setParameter("min", 10000f);  //3 step   setting values for variables
		query.setParameter("max", 50000f);

		List<Employee> list = query.getResultList();

		for (Employee emp : list) {

			System.out.println(emp);
		}

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
