package _01.AOP.MethodInterceptor.InvokeMethod;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("01.spring.xml");
		
		EmployeeService employeeService = applicationContext.getBean("employeeServiceProxy",EmployeeService.class);
		
		try {
			employeeService.checkNameSurname();
			employeeService.sayHi("Hi!");
			employeeService.getEmployeeInfo();
		} catch (Exception e) {
			System.out.println("exception in EmployeeService#checkNameSurname()");
			e.printStackTrace();
		}
		
		
		applicationContext.close();
	}

}
