package _11.AOP.AspectJ.Around.Annotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("11.spring.xml");

		IEmployeeService employeeService = (IEmployeeService) applicationContext.getBean("employeeServiceImplBean");
		
		employeeService.checkNameSurname();
		
		employeeService.sayHi("Hello!");
		
		employeeService.getEmployeeInfo();
		
	}

}
