package _07.AOP.AspectJ.Before.Annotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _07.AOP.AspectJ.Before.Annotation.impl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("07.spring.xml");
		
		
		IEmployeeService employeeService = (IEmployeeService) applicationContext.getBean("employeeServiceImplBean");
		
		employeeService.checkNameSurname();
		
		employeeService.sayHi("Hello!");
		
		employeeService.getEmployeeInfo();
		
	}

}
