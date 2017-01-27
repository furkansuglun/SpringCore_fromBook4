package _02.AOP.NameMatchMethod.PointCutAdvisor.aop;

import org.springframework.aop.ThrowsAdvice;
//ThrowsAdvice ile exception sonrasýn yapýlacak iþler için kullanýlýrýz
public class MethodToBeDoneAfterCallException implements ThrowsAdvice{

	public void afterThrowing(IllegalArgumentException e ) throws Throwable {
		System.out.println("Spring AOP ile metotlardaki bir exception sonrasý çalýþan afterThrowing metodu.");
	}
	
}
