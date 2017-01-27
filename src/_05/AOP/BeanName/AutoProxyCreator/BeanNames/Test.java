package _05.AOP.BeanName.AutoProxyCreator.BeanNames;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("05.spring.xml");
		
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		
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
	 * Bu uygulamada config dosyasýnda simplePointCutBean ile sayHi metodu çaðýrýlýrken 
	 * araya advisor geliyor ve o iþminde gerçekleþmesi saüðlanýyoýr.simpleAdvisorBean
	 * advisor ýn çaðýracaðý bean  propertiesBeforeAndAfterTheInvokedMethodBean
	 */
	
}
