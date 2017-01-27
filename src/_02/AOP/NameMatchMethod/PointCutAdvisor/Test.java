package _02.AOP.NameMatchMethod.PointCutAdvisor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("02.spring.xml");
		
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

	
	/**
	 * Bu uygulamada config dosyas�nda simplePointCutBean ile sayHi metodu �a��r�l�rken 
	 * araya advisor geliyor ve o i�minde ger�ekle�mesi sa��lan�yo�r.simpleAdvisorBean
	 * advisor �n �a��raca�� bean  propertiesBeforeAndAfterTheInvokedMethodBean
	 */
	
}
