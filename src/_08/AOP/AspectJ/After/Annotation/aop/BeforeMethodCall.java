package _08.AOP.AspectJ.After.Annotation.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeMethodCall {

	//sayHi metodundan once firstDuty metodu çalýþacak
	@Before("execution(* _08.AOP.AspectJ.After.Annotation.IEmployeeService.sayHi(..))")
	public void firstDuty(JoinPoint joinpoint) {
		System.out.println("Aspectj");
		System.out.println(joinpoint.getSignature().getName() + " isimli mettottan ÖNCE çalþýþan firstDuty metodu. ");
	}
	
	
}
