package _15.AOP.AspectJ.AfterThrowing.XML.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterMethodCall {

	public void lastDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan SONRA çalþýþan lastDuty metodu. ");
	}
	
	
}
