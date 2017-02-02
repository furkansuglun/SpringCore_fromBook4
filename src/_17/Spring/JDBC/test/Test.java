package _17.Spring.JDBC.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _17.Spring.JDBC.dao.EmployeeDAO;
import _17.Spring.JDBC.model.Employee;

public class Test {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("17.spring.xml");
		
		EmployeeDAO dao = applicationContext.getBean("employeeDAOBean" , EmployeeDAO.class);
		
		Employee employee = new Employee("hakan" , "akar" , 3);
		dao.addEmployee(employee);
		
		employee = dao.searchId(7);
		System.out.println(employee);
		
		employee = dao.searchName("hakan");
		System.out.println(employee);
		
		applicationContext.close();
		
	}
	
}
