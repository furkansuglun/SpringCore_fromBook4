package _15.AOP.AspectJ.AfterThrowing.XML.aop;

import org.aspectj.lang.JoinPoint;

public class AfterReturningMethod {

	
	public void afterReturningDuty(JoinPoint joinPoint , Object result) {
		System.out.println("Aspecj...<aop:after-returning>");
		System.out.println(joinPoint.getSignature().getName() + "metodunun GER� D�N�� DE�ER�NDEN SONRA �al��an metot");
		System.out.println(joinPoint.getSignature().getName() + "metodunun geri d�n�� de�eri : " + result );
	}
	
}
