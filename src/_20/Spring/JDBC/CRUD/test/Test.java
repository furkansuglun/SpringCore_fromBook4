package _20.Spring.JDBC.CRUD.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _20.Spring.JDBC.CRUD.dao.EmployeeDAO;
import _20.Spring.JDBC.CRUD.model.Employee;




public class Test {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("20.spring.xml");
		
		EmployeeDAO dao = applicationContext.getBean("employeeDAOBean" , EmployeeDAO.class);
		
		Employee employee  = new Employee();
		employee.setName("Furkan");
		employee.setSurname("Süðlün");
		employee.setExperience(3);
		
		System.out.println("Create");
		dao.createEmployee1(employee);
		
		System.out.println("Read");
		dao.readEmployee1(16);
		
		System.out.println("Update");
		employee.setName("Ali");
		employee.setSurname("Veli");
		employee.setExperience(2);
		dao.updateEmployee1(employee, 7);
		
		System.out.println("Güncelleme sonrasý listedeki son durum");
		List<Employee> employees = dao.listAllEmployees1();
		System.out.println(employees);
		
		
		
		applicationContext.close();
		
	}
	
}
