package _01.MethodInterceptor.InvokeMethod.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PropertiesBeforeAndAfterTheInvokedMethod implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//ayn� before metodu gibi
		System.out.println("�a��r�lan metodun �nceki durumu#invoke");
		System.out.println("�a��r�lan metodun ad�#invoke : " + invocation.getMethod().getName());
		System.out.println("�a��r�lan metodun argumentleri#invoke : " + Arrays.toString(invocation.getArguments()));
		try {
			
			//proceed �al��an bir metottan sonra varsa ba�ka di�er metodu daha �a��r�r
			Object result = invocation.proceed();
			//Ayn� AfterReturning gibi
			System.out.println("�a��r�lan metodun sonraki durumu#invoke");
			return result;
		} catch (IllegalArgumentException e) {
			//ayn� AfterThrowing metodu gibi
			System.out.println("�a��r�lan metotda exception meydana gelmesi#invoke");
			throw e;
		}
		
	}

}
