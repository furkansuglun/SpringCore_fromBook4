package _16.AOP.AspectJ.Around.XML.aop;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingMethod {

	public void afterThrowingDuty(JoinPoint joinPoint , Throwable exception) {
		System.out.println("AspectJ...<aop:afterThrowing>");
		System.out.println(joinPoint.getSignature().getName() + " isimli metodun EXCEPTION sonrasý çalýþan metot.");
		System.out.println(joinPoint.getSignature().getName() + " metodunda meydana gelen hata : " + exception);
	}
	
}
