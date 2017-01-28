package _14.AOP.AspectJ.AfterReturning.XML.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeMethodCall {

	public void firstDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj..........<aop:before>");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan ÖNCE çalþýþan firstDuty metodu. ");
	}
	
	
}
