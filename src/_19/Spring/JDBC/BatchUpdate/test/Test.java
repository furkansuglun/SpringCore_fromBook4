package _19.Spring.JDBC.BatchUpdate.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _19.Spring.JDBC.BatchUpdate.dao.EmployeeDAO;
import _19.Spring.JDBC.BatchUpdate.model.Employee;




public class Test {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("19.spring.xml");
		
		EmployeeDAO dao = applicationContext.getBean("employeeDAOBean" , EmployeeDAO.class);
		
		Employee employee  = new Employee("name" ,  "surname"  , 11);
		Employee employee2 = new Employee("name2" , "surname2" , 12);
		Employee employee3 = new Employee("name3" , "surname3" , 13);
		Employee employee4 = new Employee("name4" , "surname4" , 14);
		Employee employee5 = new Employee("name5" , "surname5" , 15);
		Employee employee6 = new Employee("name6" , "surname6" , 16);
		Employee employee7 = new Employee("name7" , "surname7" , 17);
		Employee employee8 = new Employee("name8" , "surname8" , 18);
		Employee employee9 = new Employee("name9" , "surname9" , 19);
		
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		employees.add(employee7);
		employees.add(employee8);
		employees.add(employee9);
		
		System.out.println("Ekelencek liste : "+ employees);
		
		System.out.println("\n\nyeni kayýt öncesi butun kayýtlar\n" + dao.searchAll());
		
		dao.dataEntryBatch1(employees);
		
		System.out.println("\n\nyeni kayýt sonrasý butun kayýtlar\n" + dao.searchAll());
		
		//sorgu ile guncelleme
		dao.dataEntryBatch2("update employee set surname='SOYADIDEGISTI' where surname='surname2' ");
		
		
		
		applicationContext.close();
		
	}
	
}
