package _13.AOP.AspectJ.After.XML;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("13.spring.xml");

		IEmployeeService employeeService = (IEmployeeService) applicationContext.getBean("employeeServiceImplBean");
		
		employeeService.checkNameSurname();
		
		employeeService.sayHi("Hello!");
		
		employeeService.getEmployeeInfo();
		
	}

}
