package _05.AOP.BeanName.AutoProxyCreator.BeanNames.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PropertiesBeforeAndAfterTheInvokedMethod implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//ayný before metodu gibi
		System.out.println("çaðýrýlan metodun önceki durumu#invoke");
		System.out.println("çaðýrýlan metodun adý#invoke : " + invocation.getMethod().getName());
		System.out.println("çaðýrýlan metodun argumentleri#invoke : " + Arrays.toString(invocation.getArguments()));
		try {
			
			//proceed çalýþan bir metottan sonra varsa baþka diðer metodu daha çaðýrýr
			Object result = invocation.proceed();
			//Ayný AfterReturning gibi
			System.out.println("çaðýrýlan metodun sonraki durumu#invoke");
			return result;
		} catch (IllegalArgumentException e) {
			//ayný AfterThrowing metodu gibi
			System.out.println("çaðýrýlan metotda exception meydana gelmesi#invoke");
			throw e;
		}
		
	}

}
