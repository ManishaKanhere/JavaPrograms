package com.example.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entity.Employee;

public class JpqlTest {
	;
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("PU");
	static EntityManager entityManager=entityManagerFactory.createEntityManager();
	// find by DeptName
	public static void findByDept(String dept) {
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("select e from Employee e where e.deptName=:deptName");
		query.setParameter("deptName", dept);
		List<Employee> employees=query.getResultList();
		System.out.println("Fetching records on the basis of departmen :");
		
		for(Employee employee:employees){
			
			System.out.println(employee);
			
		}
		entityManager.getTransaction().commit();
	}
	
	public static void findEmployeeByPattern() {
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("select e from Employee e where  e.empName like :nameStartWith");
		query.setParameter("nameStartWith","A%");
		List<Employee> employee=query.getResultList();
		System.out.println("Fetching records whose name start with character 'A':");
		
		for(Employee employees:employee) {
			System.out.println(employees);
		}
		entityManager.getTransaction().commit();
	}
	
	public static void sortEmployees() {
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("select e from Employee e order by  e.empName ");
		List<Employee> employee=query.getResultList();
		System.out.println("Sorting in asending order of empname:");
		
		for(Employee emp:employee) {
			System.out.println(emp);
		}
		entityManager.getTransaction().commit();
	}
	
	     public static void sortAllEmployees() {
	    	 
	    	 entityManager.getTransaction().begin();
	 		Query query=entityManager.createQuery("select e from Employee e order by e.empName DESC ");
	 		List<Employee> employee=query.getResultList();
	 		System.out.println("Sorting in Decending order of empname:");
	 		
	 		for(Employee emp1:employee) {
	 			System.out.println(emp1);
	 		}
	 		entityManager.getTransaction().commit();
	 	}
	     
	     public static void showAllDetails(String deptName, float salray) {
	    	 
	    	 
	    	 entityManager.getTransaction().begin();
	 		Query query=entityManager.createQuery("select e from Employee e group by deptName  having :depName:salary");
	 		query.setParameter("depName","salary");
	 		
	 		List<Employee> employee=query.getResultList();
			System.out.println("Fetching records whoseDeptName'HR' and salary greate then 40000:");
			
			for(Employee employees:employee) {
				System.out.println(employees);
			}
			entityManager.getTransaction().commit();
		}
	 		
	    	 
	    	 
	     
	    	 
	     
	
	
	
	
	
	public static void close() {
	entityManager.close();
	}

	public static void main(String[] args) {
		System.out.println("start");
		System.out.println("calling the FindByDept method");
		findByDept("Developer");
		System.out.println("call the by matching the name of employee");
		findEmployeeByPattern();
		System.out.println("sort the employee on ASC order on the basis of Emp name");
		sortEmployees();
		System.out.println("short in Decending order");
		//sortAllEmployees();
		close();
		
	

	}

}
