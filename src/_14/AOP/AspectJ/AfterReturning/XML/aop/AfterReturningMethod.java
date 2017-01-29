package _14.AOP.AspectJ.AfterReturning.XML.aop;

import org.aspectj.lang.JoinPoint;

public class AfterReturningMethod {

	
	public void afterReturningDuty(JoinPoint joinPoint , Object result) {
		System.out.println("Aspecj...<aop:after-returning>");
		System.out.println(joinPoint.getSignature().getName() + "metodunun GERÝ DÖNÜÞ DEÐERÝNDEN SONRA çalýþan metot");
		System.out.println(joinPoint.getSignature().getName() + "metodunun geri dönüþ deðeri : " + result );
	}
	
}
