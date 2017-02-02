package _18.Spring.JDBC.RowMapper.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _18.Spring.JDBC.RowMapper.dao.EmployeeDAO;
import _18.Spring.JDBC.RowMapper.model.Employee;



public class Test {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("18.spring.xml");
		
		EmployeeDAO dao = applicationContext.getBean("employeeDAOBean" , EmployeeDAO.class);
		
		Employee employee = new Employee("furkan" , "süðlün" , 3);
		//dao.addEmployee(employee);
		
		employee = dao.searchId(1);
		System.out.println(employee);
		
		employee = dao.searchName("ali");
		System.out.println(employee);
		
		employee = dao.searchSurname("saglam");
		System.out.println(employee);
		
		employee = dao.searchExperience(3);
		System.out.println(employee);
		
		System.out.println("getDataById");
		String result = dao.getDataById(1);
		System.out.println(result);
		
		
		System.out.println("List All EMployees");
		for(Employee record : dao.searchAll()) {
			System.err.println(record + "---");
		}
		
		applicationContext.close();
		
	}
	
}
