package _03.AOP.RegExMethod.PointCutAdvisor.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
//AfterReturningAdvice ile her metottan hemen sonra devreye girece metodu olusturmus oluyoruz.
public class MethodToBeDoneAfterCall implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] arg2, Object target) throws Throwable {
		System.out.println("Sprin AOP ile her methottan sonra devreye girecek olan afterReturning metodu");
	}

}
