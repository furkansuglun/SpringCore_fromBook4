package _12.AOP.AspectJ.Before.XML.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeMethodCall {

	//sayHi metodundan once firstDuty metodu çalýþacak
	//@Before("execution(* _12.AOP.AspectJ.Before.XML.IEmployeeService.sayHi(..))")
	public void firstDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj..........<aop:before>");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan ÖNCE çalþýþan firstDuty metodu. ");
	}
	
	
}
